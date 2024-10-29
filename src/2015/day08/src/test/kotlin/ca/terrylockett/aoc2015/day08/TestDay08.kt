package ca.terrylockett.aoc2015.day08

import ca.terrylockett.aoccommon.resources.Resources
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay08 {

	@Test
	fun testMemSize() {
		assertEquals(0, memorySize("\"\""))
		assertEquals(3, memorySize("\"abc\""))
		assertEquals(7, memorySize("\"aaa\\\"aaa\""))
		assertEquals(1, memorySize("\"\\x27\""))
		assertEquals(2, memorySize("\"\\x22v\""))

		assertEquals(2, memorySize("\"\\xaa\\xbb\""))
		assertEquals(2, memorySize("\"\\\\\\\\\""))
	}

	@Test
	fun part1() {
		val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
		assertEquals(12, part1(inputFilePath))
	}

//    @Test
//    fun part2() {
//        val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
//        assertEquals(0, 0)
//    }
}
