package ca.terrylockett.aoc2015.day03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.nio.charset.StandardCharsets

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay03 {

	@Test
	fun part1() {
		var inputSteam = ">".byteInputStream(StandardCharsets.UTF_8)
		assertEquals(2, part1(inputSteam))

		inputSteam = "^>v<".byteInputStream(StandardCharsets.UTF_8)
		assertEquals(4, part1(inputSteam))

		inputSteam = "^v^v^v^v^v".byteInputStream(StandardCharsets.UTF_8)
		assertEquals(2, part1(inputSteam))
	}

	@Test
	fun part2() {
		var inputSteam = "^v".byteInputStream(StandardCharsets.UTF_8)
		assertEquals(3, part2(inputSteam))

		inputSteam = "^>v<".byteInputStream(StandardCharsets.UTF_8)
		assertEquals(3, part2(inputSteam))

		inputSteam = "^v^v^v^v^v".byteInputStream(StandardCharsets.UTF_8)
		assertEquals(11, part2(inputSteam))
	}
}
