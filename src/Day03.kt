fun main() {

    fun String.multiplyOccurrences(): Int {
        val regex = "mul\\((\\d+),(\\d+)\\)".toRegex()
        return regex.findAll(this).sumOf {
            it.groupValues[1].toInt() * it.groupValues[2].toInt()
        }
    }

    fun part1(message: String): Int = message.multiplyOccurrences()

    fun part2(message: String): Int = message
        .split("do()")
        .sumOf { split ->
            split.substringBefore("don't()").multiplyOccurrences()
        }

    val testInput = readInput("Day03_test").joinToString()
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    val input = readInput("Day03")
    part1(input.joinToString()).println()
    part2(input.joinToString()).println()
}
