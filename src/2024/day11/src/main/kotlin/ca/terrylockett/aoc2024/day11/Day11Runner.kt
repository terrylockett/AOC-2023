package ca.terrylockett.aoc2024.day11;

import ca.terrylockett.aoccommon.resources.Resources;

val input: String = Resources.getInput("input.txt").orElseThrow()

fun main() {
    println("2024 day11 part1: ${part1(input)}")
//    println("2024 day11 part2: ${part2(input)}")
}



fun part1(input: String): Int {
    val list = input.lines().first().split(' ').map { it.toLong() }.toMutableList()
    
    for( unused in 0 ..< 25) {
        list.blink()
    }
    
    return list.size
}



fun part2(input: String): Int {
    TODO()
}


fun MutableList<Long>.blink() {
    
    val newList = emptyList<Long>().toMutableList()
    
    for (i in this.indices) {
        val value = this[i]
        if (value == 0L) {
            newList.add(1)
        }
        else if(value.toString().length%2 == 0) {
            val str = value.toString()
            val (left, right) = str.chunked(str.length/2).map { it.toLong() }
            newList.add(left)
            newList.add(right)
        }
        else {
            newList.add(value * 2024)
        }
    }
    
    this.clear()
    this.addAll(newList)
}



