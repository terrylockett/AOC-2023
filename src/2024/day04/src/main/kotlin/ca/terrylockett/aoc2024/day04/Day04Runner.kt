package ca.terrylockett.aoc2024.day04

import ca.terrylockett.aoccommon.resources.Resources
import java.io.File

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	println("2024 day04 part1: ${part1(inputFile)}")
	println("2024 day04 part2: ${part2(inputFile)}")
}

fun part2(inputFile: String): Int {
	val grid = makeGrid(inputFile)
	var total = 0

	val maxRow = grid.size - 1
	val maxCol = grid[0].size - 1
	val targets = listOf("MAS", "SAM")

	for ((row, charArr) in grid.withIndex()) for ((col, char) in charArr.withIndex()) {
		if (char != 'A') {
			continue
		}
		if (row == 0 || row == maxRow || col == 0 || col == maxCol) {
			continue
		}

		val strSE = "${grid[row - 1][col - 1]}$char${grid[row + 1][col + 1]}"
		val strSW = "${grid[row - 1][col + 1]}$char${grid[row + 1][col - 1]}"

		if (targets.contains(strSW) && targets.contains(strSE)) {
			total++
		}
	}

	return total
}

fun part1(inputFile: String): Int {
	val grid = makeGrid(inputFile)

	var total = 0

	for ((row, charArr) in grid.withIndex()) for ((col, char) in charArr.withIndex()) {
		if (char != 'X') {
			continue
		}
		
		val point = Point(row, col)
		// N
		if (checkIfXmasStr(grid, point, -1, 0)) total++
		// NE
		if (checkIfXmasStr(grid, point, -1, 1)) total++
		// E
		if (checkIfXmasStr(grid, point, 0, 1)) total++
		// SE
		if (checkIfXmasStr(grid, point, 1, 1)) total++
		// S
		if (checkIfXmasStr(grid, point, 1, 0)) total++
		// SW
		if (checkIfXmasStr(grid, point, 1, -1)) total++
		// W
		if (checkIfXmasStr(grid, point, 0, -1)) total++
		// NW
		if (checkIfXmasStr(grid, point, -1, -1)) total++
	}

	return total
}

fun makeGrid(inputFile: String): Array<CharArray> {
	val file = File(inputFile)
	val rows = file.readLines().first().length
	val cols = file.readLines().size

	val grid = Array(rows) { CharArray(cols) }

	for ((i, line) in file.readLines().withIndex()) {
		grid[i] = line.toCharArray()
	}

	return grid
}

data class Point(val x: Int, val y: Int)

fun checkIfXmasStr(grid: Array<CharArray>, point: Point, rowDir: Int, colDir: Int): Boolean {
	val(row, col) = point

	val maxRow = grid.size - 1
	val maxCol = grid[0].size - 1
	
	if (rowDir == -1 && row < 3) {
		return false
	}
	if (rowDir == 1 && row > maxRow - 3) {
		return false
	}
	if (colDir == -1 && col < 3) {
		return false
	}
	if (colDir == 1 && col > maxCol - 3) {
		return false
	}
	
	return "XMAS" == "X${grid[row + (1 * rowDir)][col + (1 * colDir)]}${grid[row + (2 * rowDir)][col + (2 * colDir)]}${grid[row + (3 * rowDir)][col + (3 * colDir)]}"
}
