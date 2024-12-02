import kotlin.math.abs

fun main() {

    fun isValid(list: List<Int>): Boolean {
        val diffs = list.zipWithNext()
        val allIncreasing = diffs.all { (a, b) -> b - a in 1..3 }
        val allDecreasing = diffs.all { (a, b) -> b - a in -3..-1 }
        return allIncreasing || allDecreasing
    }

    fun isValidWithDampening(list: List<Int>): Boolean {
        var isValidWithDampening = false
        for (index in 0 until list.size) {
            isValidWithDampening =
                isValidWithDampening || isValid(list.filterIndexed { i, _ -> index != i })
        }
        return isValidWithDampening
    }

    fun part1(list: List<List<Int>>): Int = list.count { isValid(it) }

    fun part2(list: List<List<Int>>): Int = list.count { isValidWithDampening(it) }

    val input = readInput("Day02").map {
        it.split(" ").map { it.toInt() }
    }
    part1(input).println()
    part2(input).println()
}
