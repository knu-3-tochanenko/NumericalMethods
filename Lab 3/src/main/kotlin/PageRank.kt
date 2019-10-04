import kotlin.math.pow
import kotlin.math.round

class PageRank(
    elements: Int,
    file: String
) {
    private val alpha = 0.75
    private var x = DoubleArray(elements) { 1.0 / elements }

    init {
        Thread.sleep(2000)
        val A = Matrix(elements)
        A getFrom file

        val R = Matrix(elements)
        MatrixGenerator.transition(R)

        val M: Matrix = alpha * A + (1 - alpha) * R
        generateRank(M)
    }

    fun getRank(index: Int): Double {
        return x[index]
    }

    private fun getMax(): Int {
        var max = 0
        for (i in x.indices)
            if (x[max] < x[i])
                max = i
        return max
    }

    private fun generateRank(matrix: Matrix) {
        var vector = DoubleArray(matrix.elements) { x[it] }
        x = matrix * vector
        val precision = 0.1.pow(PRECISION)
        while (norm(x, vector) > precision) {
            vector = x
            x = matrix * vector
        }
    }

    private fun norm(v1: DoubleArray, v2: DoubleArray): Double {
        var norm = 0.0
        for (i in v1.indices)
            norm += (v1[i] - v2[i]).pow(2)
        return norm
    }

    fun printRanks() {
        for ((index, value) in x.withIndex()) {
            println(
                "PR of page No." + ANSI_YELLOW
                        + "$index" + ANSI_RESET + " is "
                        + ANSI_GREEN + value.round(PRECISION) + ANSI_RESET
            )
        }
    }

    fun printMax() {
        println(
            ANSI_GREEN + "Page with biggest PR is " + ANSI_YELLOW + getMax()
                    + ANSI_RESET + " with the PR value of "
                    + ANSI_GREEN + x[getMax()].round(PRECISION) + ANSI_RESET
        )
    }
}

//private operator fun Matrix.plus(matrix: Matrix) =
//    Matrix(Array(matrix.elements) { i ->
//        DoubleArray(matrix.elements) { j ->
//            this[i, j] + matrix[i, j]
//        }
//    })

private operator fun Matrix.plus(matrix: Matrix): Matrix {
    val res = Matrix(matrix.elements)
    for (i in 0 until matrix.elements)
        for (j in 0 until matrix.elements)
            res[i, j] = matrix[i, j] + this[i, j]
    return res
}

//private operator fun Double.times(matrix: Matrix): Matrix =
//    Matrix(Array(matrix.elements) { i ->
//        DoubleArray(matrix.elements) { j ->
//            matrix[i, j] * this
//        }
//    })

private operator fun Double.times(matrix: Matrix): Matrix {
    val res = Matrix(matrix.elements)
    for (i in 0 until matrix.elements)
        for (j in 0 until matrix.elements)
            res[i, j] = matrix[i, j] * this
    return res
}

//private operator fun Matrix.times(vector: DoubleArray): DoubleArray {
//    val res = DoubleArray(this.elements) { 0.0 }
//    for (i in 0 until this.elements)
//        for (j in 0 until this.elements)
//            res[i] += this[i, j] * vector[j]
//    return res
//}

private operator fun Matrix.times(vector: DoubleArray): DoubleArray {
    val res = DoubleArray(this.elements) { 0.0 }
    for (i in 0 until this.elements)
        for (j in 0 until this.elements)
            res[i] += this[i, j] * vector[j]
    return res
}

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}