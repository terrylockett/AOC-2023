package ca.terrylockett.aoc2024.day04

import ca.terrylockett.aoccommon.resources.Resources
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay04 {

	@Test
	fun part1() {
		val input = Resources.getInput("test-input.txt").orElseThrow()
		assertEquals(18, part1(input))
	}

	@Test
	fun part2() {
		val input = Resources.getInput("test-input.txt").orElseThrow()
		assertEquals(9, part2(input))
	}
}
