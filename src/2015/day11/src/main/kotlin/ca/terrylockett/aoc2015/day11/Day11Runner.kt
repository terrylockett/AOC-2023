package ca.terrylockett.aoc2015.day11;

import ca.terrylockett.aoccommon.resources.Resources;
import java.io.File

val BANNED_CHARS = listOf('o', 'i', 'l')

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	val input = File(inputFile).readLines().first()
	val firstPassword = newPassword(input)
	val incrementedPassword = String(incrementCharArray(firstPassword.toCharArray()))
	val secondPassword = newPassword(incrementedPassword)

	println("2015 day11 part1: $firstPassword")
	println("2015 day11 part2: $secondPassword")
}

fun newPassword(input: String): String {
	var chars = input.toCharArray()
	while (true) {
		val bannedR = bannedCharacters(chars)
		if (!bannedR.isValid) {
			chars = bannedR.chars.toCharArray()
			continue
		}

		val straightR = straightCheck(chars)
		if (!straightR.isValid) {
			chars = straightR.chars.toCharArray()
			continue
		}

		val doublePairsResult = doubleDoubleCheck(chars)
		if (!doublePairsResult.isValid) {
			chars = doublePairsResult.chars.toCharArray()
			continue
		}
		break
	}
	return String(chars)
}

fun doubleDoubleCheck(chars: CharArray): Result {
	var firstPairFound = false

	var i = 0
	while (i < chars.size - 1) {
		if (chars[i] != chars[i + 1]) {
			i++
			continue
		}

		if (!firstPairFound) {
			firstPairFound = true
			i += 2
			continue
		}

		return Result(String(chars), true)
	}

	val toR = incrementCharArray(chars.clone())
	return Result(String(toR), false)
}

fun straightCheck(chars: CharArray): Result {
	for (i in 0..chars.size - 3) {
		if (chars[i] == chars[i + 1] - 1 && chars[i] == chars[i + 2] - 2) {
			return Result(String(chars), true)
		}
	}

	val toR = incrementCharArray(chars.clone())
	return Result(String(toR), false)
}

fun bannedCharacters(chars: CharArray): Result {
	if (!chars.intersect(BANNED_CHARS).any()) {
		return Result(String(chars), true)
	}
	
	var newChars = chars.clone()
	for ((i, c) in chars.withIndex()) {
		if (!BANNED_CHARS.contains(c)) {
			continue
		}
		newChars[i] = newChars[i].next()
		newChars = newChars.mapIndexed { idx, value ->
			return@mapIndexed if (idx > i) {
				'a'
			} else {
				value
			}
		}.toCharArray()
		break
	}

	return Result(String(newChars), false)
}

fun incrementCharArray(chars: CharArray): CharArray {
	for (i in chars.size - 1 downTo 0) {
		chars[i] = chars[i].next()
		if (chars[i] != 'a') {
			break
		}
	}
	return chars
}

data class Result(val chars: String, val isValid: Boolean)

fun Char.next(): Char {
	if (this == 'z') {
		return 'a'
	}
	return this + 1
}