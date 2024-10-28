package ca.terrylockett.aoc2015.day06

import ca.terrylockett.aoccommon.resources.Resources
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay06 {

	@Test
	fun testCreateInstruction1() {
		val expectedIns = Instruction(Operation.ENABLE, Point(0, 0), Point(999, 999))
		val actualIns = createInstruction("turn on 0,0 through 999,999")
		assertEquals(expectedIns, actualIns)
	}

	@Test
	fun testCreateInstruction2() {
		val expectedIns = Instruction(Operation.TOGGLE, Point(0, 0), Point(999, 0))
		val actualIns = createInstruction("toggle 0,0 through 999,0")
		assertEquals(expectedIns, actualIns)
	}

	@Test
	fun testCreateInstruction3() {
		val expectedIns = Instruction(Operation.DISABLE, Point(499, 499), Point(500, 500))
		val actualIns = createInstruction("turn off 499,499 through 500,500")
		assertEquals(expectedIns, actualIns)
	}

	@Test
	fun testLightGrid1() {
		val grid = LightGrid()
		grid.updateLights(Instruction(Operation.ENABLE, Point(0, 0), Point(999, 999)))
		assertEquals(1000000, grid.enabledLightCount())
		assertEquals(1000000, grid.getBrightness())
	}

	@Test
	fun testLightGrid2() {
		val grid = LightGrid()
		grid.updateLights(Instruction(Operation.TOGGLE, Point(0, 0), Point(999, 0)))
		assertEquals(1000, grid.enabledLightCount())
		assertEquals(2000, grid.getBrightness())
	}

	@Test
	fun testLightGrid3() {
		val grid = LightGrid()
		grid.updateLights(Instruction(Operation.ENABLE, Point(499, 499), Point(500, 500)))
		assertEquals(4, grid.enabledLightCount())
		assertEquals(4, grid.getBrightness())
	}

	@Test
	fun part1() {
		val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
		assertEquals(998996, part1(inputFilePath))
	}

	@Test
	fun part2() {
		val inputFilePath = Resources.getInputFilePath("test-input.txt").orElseThrow()
		assertEquals(1001996, part2(inputFilePath))
	}
}
