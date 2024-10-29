package ca.terrylockett.aoc2015.day07

import ca.terrylockett.aoccommon.resources.Resources
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay07 {

	@Test
	fun blah() {
		assertEquals(65412, (UShort.MAX_VALUE - 123.toUShort()).toInt())
	}

	@Test
	fun part1() {
		val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
		assertEquals(72, part1(inputFilePath, "d"))
		assertEquals(507, part1(inputFilePath, "e"))
		assertEquals(492, part1(inputFilePath, "f"))
		assertEquals(114, part1(inputFilePath, "g"))
		assertEquals(65412, part1(inputFilePath, "h"))
		assertEquals(65079, part1(inputFilePath, "i"))
		assertEquals(123, part1(inputFilePath, "x"))
		assertEquals(456, part1(inputFilePath, "y"))
	}
}
