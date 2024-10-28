package ca.terrylockett.aoc2015.day06

import ca.terrylockett.aoccommon.resources.Resources
import java.io.File
import java.util.regex.Pattern

val INSTRUCTION_PATTERN: Pattern = Pattern.compile("(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)")

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()
	println("2015 day06 part1: ${part1(inputFile)}")
	println("2015 day06 part2: ${part2(inputFile)}")
}

data class Point(val x: Int, val y: Int)

data class Instruction(val operation: Operation, val start: Point, val end: Point)

enum class Operation {
	ENABLE,
	DISABLE,
	TOGGLE,
}

class LightNode() {
	private var isEnabled = false
	private var brightness = 0

	fun action(operation: Operation) {
		isEnabled = when (operation) {
			Operation.ENABLE -> true.also { brightness++ }
			Operation.DISABLE -> false.also { if (brightness > 0) brightness-- }
			Operation.TOGGLE -> !isEnabled.also { brightness += 2 }
		}
	}

	fun isEnabled(): Boolean {
		return isEnabled
	}
	
	fun brightness(): Int {
		return brightness
	}
}

class LightGrid() {
	private val grid = Array(1000) {
		Array(1000) {
			LightNode()
		}
	}

	fun updateLights(instruction: Instruction) {
		val(operation, start, end) = instruction
		
		for (x in start.x..end.x) {
			for (y in start.y..end.y) {
				grid[x][y].action(operation)
			}
		}
	}

	fun enabledLightCount(): Int {
		var count = 0

		for (x in 0..999) {
			for (y in 0..999) {
				if (grid[x][y].isEnabled()) {
					count++
				}
			}
		}
		return count
	}
	
	fun getBrightness(): Int {
		var count = 0

		for (x in 0..999) {
			for (y in 0..999) {
				count += grid[x][y].brightness()
			}
		}
		return count
	}
}

fun part1(inputFilePath: String): Int {
	return runInstructions(inputFilePath).enabledLightCount()
}

fun part2(inputFilePath: String): Int {
	return runInstructions(inputFilePath).getBrightness()
}

fun runInstructions(inputFilePath: String): LightGrid {
	val grid = LightGrid()

	File(inputFilePath).forEachLine { line ->
		grid.updateLights(createInstruction(line))
	}

	return grid
}

fun createInstruction(line: String): Instruction {
	val m = INSTRUCTION_PATTERN.matcher(line)
	if (!m.find()) {
		error("instruction regex didn't match!")
	}
	val operation = when (m.group(1)) {
		"turn on" -> Operation.ENABLE
		"turn off" -> Operation.DISABLE
		"toggle" -> Operation.TOGGLE
		else -> error("Unexpected value for instruction type: ${m.group(1)}")
	}
	val start = Point(m.group(2).toInt(), m.group(3).toInt())
	val end = Point(m.group(4).toInt(), m.group(5).toInt())

	return Instruction(operation, start, end)
}
