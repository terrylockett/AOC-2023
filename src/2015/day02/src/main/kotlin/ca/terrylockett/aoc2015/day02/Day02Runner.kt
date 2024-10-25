package ca.terrylockett.aoc2015.day02

import ca.terrylockett.aoccommon.resources.Resources
import java.io.File

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	println("2015 day02 part1: ${part1(inputFile)}")
	println("2015 day02 part2: ${part2(inputFile)}")
}

class Box(private val width: Int, private val height: Int, private val length: Int) {
	
	fun surfaceArea(): Int {
		return (2 * width * height) + (2 * width * length) + (2 * height * length)
	}

	fun smallestSideArea(): Int {
		return when (listOf(width, height, length).max()) {
			width -> height * length
			height -> width * length
			length -> width * height
			else -> error("Couldn't find smallest Side")
		}
	}

	fun cubicVolume(): Int {
		return width * height * length
	}
	
	fun smallestSidePerimeter(): Int {
		return when (listOf(width, height, length).max()) {
			width -> (2 * height) + (2 * length)
			height -> (2 * width) + (2 * length)
			length -> (2 * width) + (2 * height)
			else -> error("Couldn't find smallest Side")
		}
	}
}

fun part1(inputFile: String): Int {
	var totalArea = 0
	File(inputFile).readLines().forEach {
		val box = createBox(it)
		totalArea += box.surfaceArea()
		totalArea += box.smallestSideArea()
	}
	return totalArea
}

fun part2(inputFile: String): Int {
	var totalRibbonAmount = 0
	File(inputFile).readLines().forEach {
		val box = createBox(it)
		totalRibbonAmount += box.smallestSidePerimeter()
		totalRibbonAmount += box.cubicVolume()
	}
	return totalRibbonAmount
}

private fun createBox(dimensions: String): Box {
	val (width, height, length) = dimensions
		.split("x")
		.map(String::toInt)
		.toList()

	return Box(width, height, length)
}
