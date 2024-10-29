package ca.terrylockett.aoc2015.day08

import ca.terrylockett.aoccommon.resources.Resources
import java.io.File

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	println("2015 day08 part1: ${part1(inputFile)}")
	// println("2015 day08 part2: TODO")
}

fun part1(inputfilePath: String): Int {
	var memLengthTotal = 0
	var strLengthTotal = 0

	File(inputfilePath).forEachLine { line ->
		strLengthTotal += line.length
		memLengthTotal += memorySize(line)
	}
	return strLengthTotal - memLengthTotal
}

fun memorySize(escapedString: String): Int {
	val chars = escapedString.toCharArray()
	var memLength = escapedString.length
	var i = 0
	while (i < chars.size) {
		val c = chars[i]
		if (c != '\\') {
			i++
			continue
		}

		val next = chars[i + 1]
		when (next) {
			'"', '\\' -> {
				i += 2
				memLength--
				continue
			}

			'x' -> {
				val a = chars[i + 2]
				val b = chars[i + 3]
				if (isHexChar(a) && isHexChar(b)) {
					i += 4
					memLength -= 3
					continue
				}
			}
		}

		i++
	}

	return memLength - 2 // -2 for the surrounding  quotes
}

val hexChars = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')
fun isHexChar(char: Char): Boolean {
	return hexChars.contains(char)
}
