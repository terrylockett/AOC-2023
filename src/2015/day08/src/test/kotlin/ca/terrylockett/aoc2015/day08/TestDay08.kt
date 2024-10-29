package ca.terrylockett.aoc2015.day08

import ca.terrylockett.aoccommon.resources.Resources
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay08 {

	@Test
	fun testDecodeMemSize() {
		assertEquals(0, decodedMemorySize("\"\""))
		assertEquals(3, decodedMemorySize("\"abc\""))
		assertEquals(7, decodedMemorySize("\"aaa\\\"aaa\""))
		assertEquals(1, decodedMemorySize("\"\\x27\""))
		assertEquals(2, decodedMemorySize("\"\\x22v\""))

		assertEquals(2, decodedMemorySize("\"\\xaa\\xbb\""))
		assertEquals(2, decodedMemorySize("\"\\\\\\\\\""))
	}

	@Test
	fun part1() {
		val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
		assertEquals(12, part1(inputFilePath))
	}

	@Test
	fun testEncodeMemSize() {
		assertEquals(6, encodedMemorySize("\"\""))
		assertEquals(9, encodedMemorySize("\"abc\""))

		assertEquals(16, encodedMemorySize("\"aaa\\\"aaa\""))
		assertEquals(11, encodedMemorySize("\"\\x27\""))
	}

	@Test
	fun part2() {
		val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
		assertEquals(19, part2(inputFilePath))
	}
}
