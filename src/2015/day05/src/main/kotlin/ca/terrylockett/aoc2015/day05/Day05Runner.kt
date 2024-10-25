package ca.terrylockett.aoc2015.day05

import ca.terrylockett.aoccommon.resources.Resources
import java.io.File
import java.util.regex.Pattern

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	println("2015 day05 part1: ${part1(inputFile)}")
	println("2015 day05 part2: ${part2(inputFile)}")
}

fun part1(inputFile: String): Int {
	var count = 0
	File(inputFile).readLines().forEach { line ->
		if (hasThreeVowels(line) && !containsBadStrings(line) && containsDuplicateLetter(line)) {
			count++
		}
	}
	return count
}

fun part2(inputFile: String): Int {
	var count = 0
	File(inputFile).readLines().forEach { line ->
		if (doubleLetterSequence(line) && singleSpacesDouble(line)) {
			count++
		}
	}
	return count
}

fun doubleLetterSequence(line: String): Boolean {
	val chars = line.toCharArray()
	for ((index, value) in chars.withIndex()) {
		if (index + 3 == line.length) {
			break
		}
		for (i in index + 2..line.length - 2) {
			if (value == chars[i] && chars[index + 1] == chars[i + 1]) {
				return true
			}
		}
	}
	return false
}

fun singleSpacesDouble(line: String): Boolean {
	val chars = line.toCharArray()
	for ((index, value) in chars.withIndex()) {
		if (index + 2 == line.length) {
			break
		}
		if (value == chars[index + 2]) {
			return true
		}
	}
	return false
}

fun hasThreeVowels(line: String): Boolean {
	val doubleVowelPattern = Pattern.compile("[aeiou].*[aeiou].*[aeiou]")
	val m = doubleVowelPattern.matcher(line)
	return m.find()
}

fun containsBadStrings(line: String): Boolean {
	val badStringsPattern = Pattern.compile("ab|cd|pq|xy")
	val m = badStringsPattern.matcher(line)
	return m.find()
}

fun containsDuplicateLetter(line: String): Boolean {
	val chars = line.toCharArray()
	for ((index, value) in chars.withIndex()) {
		if (index + 1 == line.length) {
			continue
		}
		if (value == chars[index + 1]) {
			return true
		}
	}

	return false
}
