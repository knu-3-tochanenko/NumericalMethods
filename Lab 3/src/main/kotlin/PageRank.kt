class PageRank(
    elements: Int,
    file: String
) {
    private val alpha = 0.75
    private var x = DoubleArray(elements) { 1.0 / elements }

    init {
        println("WOW")
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

    private fun generateRank(matrix: Matrix) {
        var vector = DoubleArray(matrix.elements) { x[it] }
        x = matrix * vector
        while (norm(x, vector) > PRECISION) {
            vector = x
            x = matrix * vector
        }
        println("Calculation was successful")
    }

    private fun norm(v1: DoubleArray, v2: DoubleArray): Double {
        return 0.0
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