class Gauss {
    companion object {
        @JvmStatic
        fun solve(matrix: Matrix): DoubleArray {
            val LU = Array(matrix.elements) { DoubleArray(matrix.elements) { 0.0 } }
            var sum = 0.0

            for (i in 0 until matrix.elements) {
                // Calculate U
                for (j in i until matrix.elements) {
                    sum = 0.0
                    for (k in 0 until i)
                        sum += LU[i][k] * LU[k][j]
                    LU[i][j] = matrix[i, j] - sum
                }
                // Calculate L
                for (j in i + 1 until matrix.elements) {
                    sum = 0.0
                    for (k in 0 until i)
                        sum += LU[i][k] * LU[k][j]
                    LU[j][i] = (1.0 / LU[i][i]) * (matrix[j, i] - sum)
                }
            }

            //LU = L+U-I

            //Ly = b
            val y = DoubleArray(matrix.elements) { 0.0 }
            for (i in 0 until matrix.elements) {
                sum = 0.0
                for (k in 0 until i) {
                    sum += LU[i][k] * y[k]
                }
                y[i] = matrix[i, matrix.elements] - sum
            }

            //Ux = y
            val res = DoubleArray(matrix.elements) { 0.0 }
            for (i in matrix.elements - 1 downTo 0) {
                sum = 0.0
                for (k in i + 1 until matrix.elements) {
                    sum += LU[i][k] * res[k]
                }
                res[i] = (1.0 / LU[i][i]) * (y[i] - sum)
            }

            return res
        }
    }
}