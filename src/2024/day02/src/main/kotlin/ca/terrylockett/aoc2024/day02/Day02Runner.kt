package ca.terrylockett.aoc2024.day02

import ca.terrylockett.aoccommon.resources.Resources
import java.io.File
import kotlin.math.abs

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	 println("2024 day02 part1: ${part01(inputFile)}")
	// println("2024 day02 part2: TODO")
}

fun part01(inputFile: String): Int {
	var totalSafeRecords = 0

	File(inputFile).forEachLine { line: String ->
		val tokens = line.split(" ").map { it.toInt() }

		val initialDiff = tokens[0] - tokens[1]
		val isInc = when {
			initialDiff > 0 -> false
			initialDiff < 0 -> true
			else -> return@forEachLine
		}

		for ((index, current) in tokens.withIndex()) {
			if (index == tokens.size - 1) {
				break
			}

			val next = tokens[index + 1]

			val diff = next - current
			
			if (abs(diff) > 3) {
				return@forEachLine
			}
			when (isInc) {
				true -> if (next - current <= 0) return@forEachLine
				false -> if (next - current >= 0) return@forEachLine
			}
		}

		totalSafeRecords++
	}

	return totalSafeRecords
}
