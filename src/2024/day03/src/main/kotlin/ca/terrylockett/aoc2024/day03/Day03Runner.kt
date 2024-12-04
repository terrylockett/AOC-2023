package ca.terrylockett.aoc2024.day03

import ca.terrylockett.aoccommon.resources.Resources
import java.io.File
import java.io.InputStream
import java.nio.charset.Charset
import java.util.regex.Matcher
import java.util.regex.Pattern


fun main() {
	val input: String = Resources.getInput("input.txt").orElseThrow()

	var startTime = System.currentTimeMillis()
	val part1Result = part01(input)
	val part1Time = System.currentTimeMillis() - startTime
	println("part1(${part1Time}ms): $part1Result")

	startTime = System.currentTimeMillis()
	val part2Result = part02(input)
	val part2Time = System.currentTimeMillis() - startTime
	println("part2(${part2Time}ms): $part2Result")
}

val MEMORY_PATTERN = Pattern.compile("""mul\((\d{1,3}),(\d{1,3})\)""")!!

fun part01(input: String): Long {
	var total = 0L
	var index = 0
	val m: Matcher = MEMORY_PATTERN.matcher(input)

	while (m.find(index)) {
		index = m.end(2)
		total += m.group(1).toLong() * m.group(2).toLong()
	}
	return total
}

val DO_PATTERN = Pattern.compile("""do\(\)""")!!
val MEMORY_PATTERN2 = Pattern.compile("""mul\((\d{1,3}),(\d{1,3})\)|(don't\(\))""")!!

fun part02(input: String): Long {
	var total = 0L
	var index = 0
	
	val enabledMatcher = MEMORY_PATTERN2.matcher(input)
	val disabledMatcher = DO_PATTERN.matcher(input)
	var m = enabledMatcher
	
	while (m.find(index)) {
		index = m.end()
		val isEnabled = (m == enabledMatcher)
		if (isEnabled) {
			if (m.group(3) != null) {
				m = disabledMatcher
			} else {
				total += m.group(1).toLong() * m.group(2).toLong()
			}
		} else {
			m = enabledMatcher
		}
	}
	return total
}
