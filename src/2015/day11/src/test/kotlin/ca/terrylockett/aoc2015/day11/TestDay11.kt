package ca.terrylockett.aoc2015.day11;

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDay11 {

	@Test
	fun testCharIncrement() {
		assertEquals('b', 'a'.next())
		assertEquals('a', 'z'.next())
	}

	@Test
	fun testIncrementArr() {
		assertEquals("abce", String(incrementCharArray("abcd".toCharArray())))
		assertEquals("abcea", String(incrementCharArray("abcdz".toCharArray())))
	}

	@Test
	fun testBannedCharacters() {
		assertEquals(Result("hjaa", false), bannedCharacters("hijk".toCharArray()))
		assertEquals(Result("aajaa", false), bannedCharacters("aaiol".toCharArray()))
		assertEquals(Result("ghjaabcc", true), bannedCharacters("ghjaabcc".toCharArray()))
	}

	@Test
	fun testStraightCheck() {
		assertEquals(Result("aab", false), straightCheck("aaa".toCharArray()))
		assertEquals(Result("aabcd", true), straightCheck("aabcd".toCharArray()))
		assertEquals(Result("aabc", true), straightCheck("aabc".toCharArray()))
		assertEquals(Result("ghjaabcc", true), straightCheck("ghjaabcc".toCharArray()))
	}

	@Test
	fun testDoubleDoubleCheck() {
		assertEquals(Result("aab", false), doubleDoubleCheck("aaa".toCharArray()))
		assertEquals(Result("aabcdeff", true), doubleDoubleCheck("aabcdeff".toCharArray()))
		assertEquals(Result("aanff", true), doubleDoubleCheck("aanff".toCharArray()))
		assertEquals(Result("aaff", true), doubleDoubleCheck("aaff".toCharArray()))
		assertEquals(Result("abcdefgi", false), doubleDoubleCheck("abcdefgh".toCharArray()))
		assertEquals(Result("ghjaabcc", true), doubleDoubleCheck("ghjaabcc".toCharArray()))
	}

	@Test
	fun testNewPassword() {
		assertEquals("ghjaabcc", newPassword("ghjaabcc"))
		assertEquals("abcdffaa", newPassword("abcdefgh"))
		assertEquals("ghjaabcc", newPassword("ghijklmn"))
	}

}
