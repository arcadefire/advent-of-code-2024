package Day01

import println
import readInput
import kotlin.math.abs

fun main() {
    fun part1(first: List<Int>, second: List<Int>): Int {
        return first.sorted()
            .zip(second.sorted())
            .sumOf { (a, b) -> abs(a - b) }
    }

    fun part2(first: List<Int>, second: List<Int>): Int {
        val count = second.groupingBy { it }.eachCount()
        return first.sumOf { it * count.getOrDefault(it, 0) }
    }

    val input = readInput("Day01")
    val (firstList, secondList) = input
        .map { it.split("   ") }
        .map { parts -> parts[0].toInt() to parts[1].toInt() }
        .unzip()

    part1(firstList, secondList).println()
    part2(firstList, secondList).println()
}
