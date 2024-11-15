package ca.terrylockett.aoc2015.day12;

import ca.terrylockett.aoccommon.resources.Resources;
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import java.io.File

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()
	val input = File(inputFile).readText()

	println("2015 day12 part1: ${part1(input)}")
	println("2015 day12 part2: ${part2(input)}")
}


fun part1(input: String): Int {
	val rootElement = JsonParser.parseString(input)
	return traverseJsonPart1(rootElement, 0)
}

fun traverseJsonPart1(jsonElement: JsonElement, total: Int): Int {
	if (jsonElement.isJsonObject) {
		val o = jsonElement.asJsonObject!!
		return total + o.entrySet().sumOf { traverseJsonPart1(it.value, 0) }
	} else if (jsonElement.isJsonArray) {
		return total + jsonElement.asJsonArray!!.sumOf { traverseJsonPart1(it, 0) }
	} else {
		if (jsonElement.asJsonPrimitive!!.isNumber) {
			return total + jsonElement.asNumber!!.toInt()
		}
		return total
	}
}


fun part2(input: String): Int {
	val rootElement = JsonParser.parseString(input)
	return traverseJsonPart2(rootElement, 0)
}

fun traverseJsonPart2(jsonElement: JsonElement, total: Int): Int {
	if (jsonElement.isJsonObject) {
		val jsonObject = jsonElement.asJsonObject!!

		val hasChildContainingRed = jsonObject.entrySet().any {
			it.value.isJsonPrimitive && it.value.asJsonPrimitive!!.isString && it.value.asJsonPrimitive.asString == "red"
		}

		if (hasChildContainingRed) {
			return total
		}
		return total + jsonObject.entrySet().sumOf { traverseJsonPart2(it.value, 0) }

	} else if (jsonElement.isJsonArray) {
		return total + jsonElement.asJsonArray!!.sumOf { traverseJsonPart2(it, 0) }
	} else {
		if (jsonElement.asJsonPrimitive!!.isNumber) {
			return total + jsonElement.asNumber!!.toInt()
		}
		return total
	}
}
