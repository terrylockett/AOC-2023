package ca.terrylockett.aoc2024.day01

import ca.terrylockett.aoccommon.resources.Resources
import java.io.File
import kotlin.math.abs

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	println("2024 day01 part1: ${part01(inputFile)}")
	println("2024 day01 part2: ${part02(inputFile)}")
}

fun part01(inputFile: String): Int {
	val leftNumbers = ArrayList<Int>()
	val rightNumbers = ArrayList<Int>()

	File(inputFile).forEachLine { line: String ->
		val (left, right) = line.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toList()
		leftNumbers.add(left)
		rightNumbers.add(right)
	}

	leftNumbers.sort()
	rightNumbers.sort()

	var total = 0
	for ((index, left) in leftNumbers.withIndex()) {
		val right = rightNumbers[index]
		total += abs(left - right)
	}

	return total
}

fun part02(inputFile: String): Int {
	val leftNumbers = ArrayList<Int>()
	val rightNumbersCounts = HashMap<Int, Int>()

	File(inputFile).forEachLine { line: String ->
		val (left, right) = line.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toList()
		leftNumbers.add(left)
		rightNumbersCounts[right] = (rightNumbersCounts[right] ?: 0).inc()
	}

	var total = 0
	for (left in leftNumbers) {
		val right = rightNumbersCounts[left] ?: 0
		total += left * right
	}

	return total
}
