class MatrixGenerator {
    companion object {
        fun transition(matrix: Matrix) {
            val elements = matrix.elements
            val value = 1.0 / elements
            for (i in 0 until elements)
                for (j in 0 until elements)
                    matrix[i, j] = value
        }
    }
}

