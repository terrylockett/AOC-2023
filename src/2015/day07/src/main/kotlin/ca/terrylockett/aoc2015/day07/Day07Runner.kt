package ca.terrylockett.aoc2015.day07

import ca.terrylockett.aoccommon.resources.Resources
import java.io.File

fun main() {
	val inputFile: String = Resources.getInputFilePath("input.txt").orElseThrow()

	val aSignal = part1(inputFile, "a")
	println("2015 day07 part1: $aSignal")
	
	println("2015 day07 part2: ${part2(inputFile, "a", aSignal)}")
}

val nodes = HashMap<String, Node>()

fun part1(inputFilePath: String, startId: String): Int {
	buildTree(inputFilePath)
	val startNode = nodes.getValue(startId)
	return startNode.getSignal()
}

fun part2(inputFilePath: String, startId: String, bSignalOverride: Int): Int {
	nodes.clear()
	buildTree(inputFilePath)
	nodes["b"] = Constant(bSignalOverride)

	val startNode = nodes.getValue(startId)
	return startNode.getSignal()
}

class Wire(private val inputSignalId: String) : Node {
	private var evaluated = false
	private var evalSignal = 0

	override fun getSignal(): Int {
		if (evaluated) {
			return evalSignal
		}

		evalSignal = nodes.getValue(inputSignalId).getSignal()
		evaluated = true
		return evalSignal
	}
}

data class Gate(private val operator: GateOperator, private val input1Id: String, private val input2Id: String?) :
	Node {
	private var evaluated = false
	private var evalSignal = 0

	override fun getSignal(): Int {
		if (evaluated) {
			return evalSignal
		}

		val wire1: Node = if (isNumeric(input1Id)) {
			Constant(input1Id.toInt())
		} else {
			nodes.getValue(input1Id)
		}
		val wire2: Node? = if (isNumeric(input2Id)) {
			Constant(input2Id!!.toInt())
		} else {
			nodes[input2Id]
		}

		evalSignal = when (operator) {
			GateOperator.AND -> wire1.getSignal() and wire2!!.getSignal()
			GateOperator.OR -> wire1.getSignal() or wire2!!.getSignal()
			GateOperator.NOT -> (UShort.MAX_VALUE - wire1.getSignal().toUShort()).toInt()
			GateOperator.LSHIFT -> wire1.getSignal() shl wire2!!.getSignal()
			GateOperator.RSHIFT -> wire1.getSignal() shr wire2!!.getSignal()
		}
		evaluated = true
		return evalSignal
	}
}

class Constant(private val num: Int) : Node {
	override fun getSignal(): Int {
		return num
	}
}

fun interface Node {
	fun getSignal(): Int
}

fun buildTree(inputFilePath: String) {
	File(inputFilePath).forEachLine { line ->
		val (leftExpression, targetWire) = line.split(" -> ")
		if (leftExpression.contains(" ")) {
			val tokens = leftExpression.split(" ")
			if (tokens.size == 2) {
				nodes[targetWire] = Gate(GateOperator.NOT, tokens[1], null)
			} else {
				when (tokens[1]) {
					"AND" -> nodes[targetWire] = Gate(GateOperator.AND, tokens[0], tokens[2])
					"OR" -> nodes[targetWire] = Gate(GateOperator.OR, tokens[0], tokens[2])
					"LSHIFT" -> nodes[targetWire] = Gate(GateOperator.LSHIFT, tokens[0], tokens[2])
					"RSHIFT" -> nodes[targetWire] = Gate(GateOperator.RSHIFT, tokens[0], tokens[2])
				}
			}
		} else {
			if (isNumeric(leftExpression)) {
				val const = Constant(leftExpression.toInt())
				nodes[targetWire] = const
			} else {
				nodes[targetWire] = Wire(leftExpression)
			}
		}
	}
}

fun isNumeric(input: String?): Boolean {
	if (null == input) {
		return false
	}
	return input.all { char -> char.isDigit() }
}

enum class GateOperator {
	AND,
	OR,
	NOT,
	LSHIFT,
	RSHIFT,
}
