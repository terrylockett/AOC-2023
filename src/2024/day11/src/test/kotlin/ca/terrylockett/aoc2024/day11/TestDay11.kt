package ca.terrylockett.aoc2024.day11;

import ca.terrylockett.aoccommon.resources.Resources;
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay11 {
    
    @Test
    fun testBlink() {
        val inputList = listOf(125,17).map { it.toLong() }.toMutableList()
        
        var expected = listOf(253000, 1, 7).map { it.toLong() }.toMutableList()
        inputList.blink()
        assertEquals(expected,inputList)

        expected = listOf(253, 0, 2024, 14168).map {it.toLong() }.toMutableList()
        inputList.blink()
        assertEquals(expected,inputList)
    }

    @Test
    fun part1() {
        val input = Resources.getInput("test-input.txt").orElseThrow()
        assertEquals(55312, part1(input))
    }
    
//    @Test
//    fun part2() {
//        val input = Resources.getInput("test-input.txt").orElseThrow()
//        assertEquals(0, 0)
//    }
}
