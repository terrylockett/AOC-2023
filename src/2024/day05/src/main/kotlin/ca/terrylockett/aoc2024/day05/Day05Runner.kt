package ca.terrylockett.aoc2024.day05

import ca.terrylockett.aoccommon.resources.Resources

val input: String = Resources.getInput("input.txt").orElseThrow()

fun main() {
	println("2024 day05 part1: ${part1(input)}")
	// println("2024 day05 part2: ${part2(input)}")
}

data class Pair(val x: Int, val y: Int)
data class SafetyManual(val mappings: List<Pair>, val rules: List<IntArray>)

fun part1(input: String): Int {
	val safetyManual = createSafetyManual(input)

	var total = 0
	for (rule: IntArray in safetyManual.rules) {
		var isValid = true
		for (pair in safetyManual.mappings) {
			if (!rule.contains(pair.x) || !rule.contains(pair.y)) {
				continue
			}

			if (rule.indexOf(pair.x) > rule.indexOf(pair.y)) {
				isValid = false
				break
			}
		}
		if (isValid) {
			total += rule[rule.size / 2]
		}
	}

	return total
}

fun createSafetyManual(input: String): SafetyManual {
	val lines = input.lines()

	val mappings = ArrayList<Pair>()
	val rules = ArrayList<IntArray>()

	var isParseMappings = true
	for (line in lines) {
		if (line.isEmpty()) {
			isParseMappings = false
			continue
		}

		if (isParseMappings) {
			val(left, right) = line.split("|").map { it.toInt() }
			mappings.add(Pair(left, right))
		} else {
			rules.add(line.split(",").map { it.toInt() }.toIntArray())
		}
	}

	return SafetyManual(mappings, rules)
}

fun part2(input: String): Int {
	TODO()
}
