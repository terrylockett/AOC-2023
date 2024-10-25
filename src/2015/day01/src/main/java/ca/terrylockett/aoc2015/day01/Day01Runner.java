package ca.terrylockett.aoc2015.day01;

import ca.terrylockett.aoccommon.resources.Resources;

import java.io.FileReader;
import java.io.IOException;

public class Day01Runner {

	static final String INPUT_FILE_NAME = "input.txt";

	public static void main(String[] args) throws Exception {
		String inputFilePath = Resources.getInputFilePath(INPUT_FILE_NAME).orElseThrow();

		System.out.println("2015 day01 part1: " + part1(inputFilePath));
		System.out.println("2015 day01 part2: " + part2(inputFilePath));
	}

	static Integer part1(String filePath) throws IOException {
		int floor = 0;
		try (var fileReader = new FileReader(filePath)) {
			int character;
			while ((character = fileReader.read()) != -1) {
				floor += elevatorMovement(character);
			}
		}
		return floor;
	}

	static Integer part2(String filePath) throws IOException {
		int floor = 0;
		int instructionCount = 0;
		try (var fileReader = new FileReader(filePath)) {
			int character;
			while ((character = fileReader.read()) != -1) {
				floor += elevatorMovement(character);
				instructionCount++;
				if (-1 == floor) {
					return instructionCount;
				}
			}
		}
		throw new IllegalStateException("Elevator Never went to basement.");
	}

	private static Integer elevatorMovement(int character) {
		int value = 0;
		switch (character) {
			case '(' -> value++;
			case ')' -> value--;
			default -> throw new IllegalStateException("Unexpected value: " + character);
		}
		return value;
	}
}
