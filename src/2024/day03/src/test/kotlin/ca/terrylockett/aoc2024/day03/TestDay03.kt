package ca.terrylockett.aoc2024.day03

import ca.terrylockett.aoccommon.resources.Resources
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.io.File
import java.nio.charset.Charset

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay03 {

	@Test
	fun part1() {
		val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
		val input = File(inputFilePath).readLines(Charset.defaultCharset())
		assertEquals(161, part01(input))
	}

//    @Test
//    fun part2() {
//        val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
//        assertEquals(0, 0)
//    }
}
