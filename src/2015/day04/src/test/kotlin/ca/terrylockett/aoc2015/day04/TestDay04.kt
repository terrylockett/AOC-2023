package ca.terrylockett.aoc2015.day04;

import ca.terrylockett.aoccommon.resources.Resources;
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay04 {

    @Test
    fun testMd5Hit() {
        var inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
        assertEquals(609043, findMD5Hit(inputFilePath, "00000"))

        inputFilePath = Resources.getInputFilePath("test-input2.txt").orElseThrow()
        assertEquals(1048970, findMD5Hit(inputFilePath, "00000"))
    }
}
