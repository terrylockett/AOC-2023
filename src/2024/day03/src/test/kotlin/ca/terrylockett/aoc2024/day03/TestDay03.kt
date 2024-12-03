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
		val input = File(inputFilePath).readText(Charset.defaultCharset())
		assertEquals(161, part01(input))
	}

    @Test
    fun part2() {
		val input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))\n"
        assertEquals(48, part02(input))
    }
}
