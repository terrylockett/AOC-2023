package ca.terrylockett.aoc2024.day11

import ca.terrylockett.aoccommon.resources.Resources
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State

@State(Scope.Benchmark)
open class BenchDay11 {
	private var input: String = ""
	
	@Setup
	fun init() {
		input = Resources.getInput("input.txt").orElseThrow()
	}
	
	@Benchmark
	fun part1(): Any {
		return part1(input)
	}

	@Benchmark
	fun part2(): Any {
		return part2(input)
	}
}
