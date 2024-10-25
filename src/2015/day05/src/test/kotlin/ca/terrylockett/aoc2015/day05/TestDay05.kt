package ca.terrylockett.aoc2015.day05

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay05 {

	@Test
	fun part1() {
		assertEquals(true, hasThreeVowels("aei"))
		assertEquals(true, hasThreeVowels("aeiouaeiouaeiou"))
		assertEquals(true, hasThreeVowels("xazegov"))
		assertEquals(false, hasThreeVowels("plpl"))

		assertEquals(true, containsBadStrings("haegwjzuvuyypxyu"))
		assertEquals(true, containsBadStrings("aaabaaa"))

		assertEquals(true, containsDuplicateLetter("plaaplpl"))
		assertEquals(false, containsDuplicateLetter("jchzalrnumimnmhp"))
	}

	@Test
	fun part2() {
		assertEquals(true, doubleLetterSequence("aabcdefgaa"))
		assertEquals(false, doubleLetterSequence("wwaaam"))

		assertEquals(true, singleSpacesDouble("aaxyx"))
		assertEquals(true, singleSpacesDouble("qjhvhtzxzqqjkmpb"))
		assertEquals(true, singleSpacesDouble("xxyxx"))
		
		assertEquals(false, singleSpacesDouble("uurcxstgmygtbstg"))
		assertEquals(true, doubleLetterSequence("uurcxstgmygtbstg"))

		assertEquals(true, singleSpacesDouble("ieodomkazucvgmuy"))
		assertEquals(false, doubleLetterSequence("ieodomkazucvgmuy"))

		assertEquals(true, doubleLetterSequence("dedeaa"))
		assertEquals(true, doubleLetterSequence("abcdede"))
	}
}
