package ca.terrylockett.aoc2024.day03

import ca.terrylockett.aoccommon.resources.Resources
import java.io.File
import java.nio.charset.Charset
import java.util.regex.Matcher
import java.util.regex.Pattern

val memPattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)")!!

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()
	val input= File(inputFile).readLines(Charset.defaultCharset())
	
	 println("2024 day03 part1: ${part01(input)}")
	// println("2024 day03 part2: TODO")
}

fun part01(input: List<String>): Long {
	var total = 0L
	
	for (line in input) {
		val m: Matcher = memPattern.matcher(line)
		
		var index = 0
		while (m.find(index)) {
			index = m.end(2)
			total += m.group(1).toLong() * m.group(2).toLong()
		}
	}
	
	return total
}
