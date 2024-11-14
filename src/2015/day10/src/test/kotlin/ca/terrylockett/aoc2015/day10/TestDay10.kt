package ca.terrylockett.aoc2015.day10;

import ca.terrylockett.aoccommon.resources.Resources;
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay10 {

    @Test 
    fun testSingleRounds() {
        assertEquals(11, gameRound("1").toInt())
        assertEquals(21, gameRound("11").toInt())
        assertEquals(111221, gameRound("1211").toInt())
        assertEquals(312211, gameRound("111221").toInt())
    }
    
    @Test
    fun part1() {
        val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
        assertEquals(6, playGame(inputFilePath, 5))
    }
    
//    @Test
//    fun part2() {
//        val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
//        assertEquals(0, 0)
//    }
}
