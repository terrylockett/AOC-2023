package ca.terrylockett.aoc2015.day10;

import ca.terrylockett.aoccommon.resources.Resources;
import java.io.File

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	println("2015 day10 part1: ${playGame(inputFile, 40)}")
	println("2015 day10 part2: ${playGame(inputFile, 50)}")
}


fun playGame(inputFile: String, rounds: Int): Int {
	var currentSequence = File(inputFile).readLines().first()

	for (i in 0..<rounds) {
		currentSequence = gameRound(currentSequence)
	}

	return currentSequence.length
}

fun gameRound(input: String): String {
	var currentChar: Char = input[0]
	var counter = 0
	var response = ""

	input.toCharArray().forEach { char ->
		if (char == currentChar) {
			counter++
		} else {
			response += "$counter$currentChar"
			currentChar = char
			counter = 1
		}
	}

	response += "$counter$currentChar"
	return response
}