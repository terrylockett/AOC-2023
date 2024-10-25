package ca.terrylockett.aoc2015.day01;

import ca.terrylockett.aoccommon.resources.Resources;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestDay01 {

	static final String TEST_FILE_NAME = "test-input.txt";

	static String testFilePath = "";

	@BeforeAll
	static void setup() throws URISyntaxException {
		testFilePath = Resources.getInputFilePath(TEST_FILE_NAME).orElseThrow();
	}

	@Test
	void testDay01part1() throws IOException {
		assertEquals(-1, Day01Runner.part1(testFilePath));
	}

	@Test
	void testDay01part2() throws IOException {
		assertEquals(5, Day01Runner.part2(testFilePath));
	}
}
