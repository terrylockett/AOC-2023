package ca.terrylockett.aoc2015.day04;

import ca.terrylockett.aoccommon.resources.Resources;
import org.apache.commons.codec.digest.DigestUtils
import java.io.File
import java.nio.charset.Charset

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	println("2015 day04 part1: ${findMD5Hit(inputFile, "00000")}")
	println("2015 day04 part2: ${findMD5Hit(inputFile, "000000")}")
}

fun findMD5Hit(inputFile: String, targetPrefix: String): Int {
	val input = File(inputFile).readLines(Charset.defaultCharset()).first()
	var testNum = 0;

	while (true) {
		val md5Hex = DigestUtils.md5Hex(input + testNum.toString())
		if (md5Hex.startsWith(targetPrefix)) {
			return testNum
		}
		testNum++
	}
}