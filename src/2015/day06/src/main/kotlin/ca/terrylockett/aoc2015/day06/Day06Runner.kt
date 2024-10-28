package ca.terrylockett.aoc2015.day06

import ca.terrylockett.aoccommon.resources.Resources
import java.io.File
import java.util.regex.Pattern

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	println("2015 day06 part1: ${part1(inputFile)}")
	//println("2015 day06 part2: TODO")
}

val INSTRUCTION_PATTERN: Pattern = Pattern.compile("(turn on|turn off|toggle) (\\d+),(\\d+) through (\\d+),(\\d+)")

fun part1(inputFilePath: String): Int {
	
	val grid = LightGrid()
	
	File(inputFilePath).forEachLine { line ->
		grid.updateLights(createInstruction(line))
	}
	
	return grid.enabledLightCount()
}


data class Point(val x: Int, val y: Int)

data class Instruction(val operation: Operation, val start: Point, val end: Point)

enum class Operation {
	ENABLE,
	DISABLE,
	TOGGLE
}

class LightNode() {
	private var isEnabled = false

	fun action(operation: Operation) {
		isEnabled = when (operation) {
			Operation.ENABLE -> true
			Operation.DISABLE -> false
			Operation.TOGGLE -> !isEnabled
		}
	}

	fun isEnabled(): Boolean {
		return isEnabled
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
				if (grid[x][y].isEnabled())
					count++
			}
		}
		return count
	}
}

fun createInstruction(line: String): Instruction {
	val m = INSTRUCTION_PATTERN.matcher(line)
	if (!m.find()) {
		error("instruction regex didn't match!")
	}
	val operation = when(m.group(1)) {
		"turn on" -> Operation.ENABLE
		"turn off" -> Operation.DISABLE
		"toggle" -> Operation.TOGGLE
		else -> error("Unexpected value for instruction type: ${m.group(1)}")
	}
	val start = Point(m.group(2).toInt(), m.group(3).toInt())
	val end = Point(m.group(4).toInt(), m.group(5).toInt())

	return Instruction(operation, start, end)
}
