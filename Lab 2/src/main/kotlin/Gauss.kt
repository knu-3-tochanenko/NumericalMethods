object Gauss {
    fun solve(matrix: Matrix): Array<Double> {
        val res: Array<Double> = Array(matrix.elements) {0.0}
        var iterations = 0
        for (i in 0 until matrix.elements - 1) {
            iterations++
            for (k in i + 1 until matrix.elements) {
                val t = (matrix[k, i] / matrix[i, i])
                for (j in 0..matrix.elements)
                    matrix[k, j] -= t * matrix[i, j]
            }
        }
        for (i in matrix.elements - 1 downTo 0) {
            iterations++
            res[i] = matrix[i, matrix.elements]
            for (j in i + 1 until matrix.elements) {
                if (j != i)
                    res[i] -=  matrix[i, j] * res[j]
            }
            res[i] /= matrix[i, i]
        }
        print(" : ($iterations)$ANSI_RESET\n")
        return res
    }
}