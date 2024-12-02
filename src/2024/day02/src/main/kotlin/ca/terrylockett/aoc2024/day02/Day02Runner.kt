package ca.terrylockett.aoc2024.day02

import ca.terrylockett.aoccommon.resources.Resources
import java.io.File
import kotlin.math.abs

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	println("2024 day02 part1: ${part01(inputFile)}")
	println("2024 day02 part2: ${part02(inputFile)}")
}

fun checkRecord(tokens: List<Int>): Boolean {
	val initialDiff = tokens[0] - tokens[1]
	val isIncreasing = when {
		initialDiff > 0 -> false
		initialDiff < 0 -> true
		else -> return false
	}

	for (diff in tokens.zipWithNext { left, right -> right - left }) {
		if (abs(diff) > 3) {
			return false
		}
		when (isIncreasing) {
			true -> if (diff <= 0) return false
			false -> if (diff >= 0) return false
		}
	}
	
	return true
}

fun part01(inputFile: String): Int {
	var totalSafeRecords = 0

	File(inputFile).forEachLine { line: String ->
		val tokens = line.split(" ").map { it.toInt() }

		if (checkRecord(tokens)) {
			totalSafeRecords++
		}
	}

	return totalSafeRecords
}

fun part02(inputFile: String): Int {
	var totalSafeRecords = 0

	File(inputFile).forEachLine { line: String ->
		val tokens = line.split(" ").map { it.toInt() }

		if (checkRecord(tokens)) {
			totalSafeRecords++
			return@forEachLine
		}
		
		for (i in tokens.indices) {
			val tmpTokens = tokens.toIntArray().copyOf().toList().toMutableList()
			tmpTokens.removeAt(i)
			
			if (checkRecord(tmpTokens)) {
				totalSafeRecords++
				return@forEachLine
			}
		}
	}

	return totalSafeRecords
}
