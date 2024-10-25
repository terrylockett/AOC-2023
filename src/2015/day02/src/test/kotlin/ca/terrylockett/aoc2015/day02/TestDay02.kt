package ca.terrylockett.aoc2015.day02

import ca.terrylockett.aoccommon.resources.Resources
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay02 {

	@Test
	fun testSurfaceArea() {
		assertEquals(52, Box(2, 3, 4).surfaceArea())
		assertEquals(42, Box(1, 1, 10).surfaceArea())
	}
	
	@Test
	fun testSmallestSide() {
		assertEquals(6, Box(2, 3, 4).smallestSideArea())
		assertEquals(1, Box(1, 1, 10).smallestSideArea())
	}

	@Test
	fun testRibbonBowLength() {
		assertEquals(24, Box(2, 3, 4).cubicVolume())
		assertEquals(10, Box(1, 1, 10).cubicVolume())
	}

	@Test
	fun testRibbonWrapLength() {
		assertEquals(10, Box(2, 3, 4).smallestSidePerimeter())
		assertEquals(4, Box(1, 1, 10).smallestSidePerimeter())
	}
	
	@Test
	fun part1() {
		val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
		assertEquals(101, part1(inputFilePath))
	}

	@Test
	fun part2() {
		val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
		assertEquals(48, part2(inputFilePath))
	}
}
