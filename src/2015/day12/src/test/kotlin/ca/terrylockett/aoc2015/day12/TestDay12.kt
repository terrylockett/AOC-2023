package ca.terrylockett.aoc2015.day12;

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay12 {

	@Test
	fun part1() {
		assertEquals(6, part1("{\"a\":2,\"b\":4}"))
		assertEquals(3, part1("{\"a\":{\"b\":4},\"c\":-1}"))
		assertEquals(0, part1("{\"a\":[-1,1]}"))
	}

	@Test
	fun part2() {
		assertEquals(4, part2("[1,{\"c\":\"red\",\"b\":2},3]"))
	}
}
