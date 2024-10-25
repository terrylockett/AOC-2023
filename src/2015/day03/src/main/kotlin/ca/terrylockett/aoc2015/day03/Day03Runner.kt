package ca.terrylockett.aoc2015.day03

import ca.terrylockett.aoccommon.resources.Resources
import java.io.FileInputStream
import java.io.InputStream
import java.util.HashSet
import java.util.Scanner

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	println("2015 day03 part1: ${part1(FileInputStream(inputFile))}")
	println("2015 day03 part2: ${part2(FileInputStream(inputFile))}")
}

class House(val x: Int, val y: Int) {
	override fun hashCode(): Int {
		return "x: $x y: $y".hashCode()
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as House

		if (x != other.x) return false
		if (y != other.y) return false

		return true
	}
}

fun part1(input: InputStream): Int {
	val visitedHouses = HashSet<House>()
	var currentHouse = House(0, 0)
	visitedHouses.add(currentHouse)

	val scanner = Scanner(input)
	scanner.useDelimiter("")

	while (scanner.hasNext()) {
		val character = scanner.next()
		currentHouse = nextHouse(character, currentHouse)
		visitedHouses.add(currentHouse)
	}
	return visitedHouses.size
}

fun part2(input: InputStream): Int {
	val visitedHouses = HashSet<House>()
	var santaCurrentHouse = House(0, 0)
	var roboCurrentHouse = House(0, 0)
	var isRoboSanta = false

	visitedHouses.add(santaCurrentHouse)

	val scanner = Scanner(input)
	scanner.useDelimiter("")

	while (scanner.hasNext()) {
		val character = scanner.next()
		val house = if (isRoboSanta) roboCurrentHouse else santaCurrentHouse
		
		visitedHouses.add(
			nextHouse(character, house).also {
				if (isRoboSanta) roboCurrentHouse = it else santaCurrentHouse = it
			},
		)
		isRoboSanta = !isRoboSanta
	}
	return visitedHouses.size
}

fun nextHouse(character: String, currentHouse: House): House {
	return when (character) {
		"^" -> House(currentHouse.x, currentHouse.y + 1)
		"v" -> House(currentHouse.x, currentHouse.y - 1)
		"<" -> House(currentHouse.x - 1, currentHouse.y)
		">" -> House(currentHouse.x + 1, currentHouse.y)
		else -> error("Unexpected character")
	}
}
