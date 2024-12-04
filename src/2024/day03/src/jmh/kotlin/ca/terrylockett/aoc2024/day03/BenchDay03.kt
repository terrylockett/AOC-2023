package ca.terrylockett.aoc2024.day03

import ca.terrylockett.aoccommon.resources.Resources
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Benchmark)
open class BenchDay03 {
	
	private var input: String = ""

	@Setup
	fun init() {
		input = Resources.getInput("input.txt").orElseThrow()
	}
	
	@Benchmark
	fun benchPart1(bh: Blackhole) {
		bh.consume(part01(input))
	}

	@Benchmark
	fun benchPart2(bh: Blackhole) {
		bh.consume(part02(input))
	}

}