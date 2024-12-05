fun main() {
    val moves = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(0, 1),
        intArrayOf(-1, -1),
        intArrayOf(-1, 1),
        intArrayOf(1, -1),
        intArrayOf(1, 1)
    )

    fun part1(mat: Array<CharArray>): Int {
        fun search(row: Int, col: Int, rowDirection: Int, colDirection: Int): Boolean {
            "XMAS".withIndex().forEach { target ->
                val newRow = row + target.index * rowDirection
                val newCol = col + target.index * colDirection
                if (newRow !in mat.indices
                    || newCol !in mat[0].indices
                    || target.value != mat[newRow][newCol]
                ) {
                    return false
                }
            }
            return true
        }

        var sum = 0
        for (row in mat.indices) {
            for (col in mat[0].indices) {
                for (move in moves) {
                    if (search(row, col, move[0], move[1])) {
                        sum++
                    }
                }
            }
        }
        return sum
    }


    fun part2(mat: Array<CharArray>): Int {
        var sum = 0
        val rows = mat.size
        val cols = mat[0].size
        for (row in 1 until rows - 1) {
            for (col in 1 until cols - 1) {
                if (mat[row][col] == 'A') {
                    val topLeft = mat[row - 1][col - 1]
                    val topRight = mat[row - 1][col + 1]
                    val bottomLeft = mat[row + 1][col - 1]
                    val bottomRight = mat[row + 1][col + 1]

                    if (setOf(topLeft, bottomRight) == setOf('M', 'S')
                        && setOf(topRight, bottomLeft) == setOf('M', 'S')
                    ) {
                        sum++
                    }
                }
            }
        }
        return sum
    }

    val testInput = readInput("Day04_test").toMatrix()
    check(part1(testInput) == 18)
    check(part2(testInput) == 9)

    val input = readInput("Day04")
    part1(input.toMatrix()).println()
    part2(input.toMatrix()).println()
}

private fun List<String>.toMatrix(): Array<CharArray> {
    return this.map { it.toCharArray() }.toTypedArray()
}
