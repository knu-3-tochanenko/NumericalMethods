class Gauss {
    companion object {
        @JvmStatic
        fun solve(matrix: Matrix, b: DoubleArray): DoubleArray {
            val L = Matrix(matrix.elements)
            val U = Matrix(matrix.elements)
            var sum = 0.0

            for (i in 0 until matrix.elements) {
                // Calculate U
                for (j in i until matrix.elements) {
                    sum = 0.0
                    for (k in 0 until i)
                        sum += L[i, k] * U[k, j]
                    U[i, j] = matrix[i, j] - sum
                }
                // Calculate L
                for (j in i until matrix.elements) {
                    sum = 0.0
                    for (k in 0 until i)
                        sum += L[i, k] * U[k, j]
                    L[j, i] = (1.0 / U[i, i]) * (matrix[j, i] - sum)
                }
            }

            print("L:")
            print(L)
            print("\n---------------\nU:")
            print(U)
            print("\n---------------\nL * U")
            print(L * U)
            print("\n---------------")

            //Ly = b
            val y = DoubleArray(matrix.elements) { 0.0 }
            for (i in 0 until matrix.elements) {
                sum = 0.0
                for (k in 0 until i) {
                    sum += L[i, k] * y[k]
                }
                y[i] = b[i] - sum
            }

            //Ux = y
            val res = DoubleArray(matrix.elements) { 0.0 }
            for (i in matrix.elements - 1 downTo 0) {
                sum = 0.0
                for (k in i + 1 until matrix.elements) {
                    sum += U[i, k] * res[k]
                }
                res[i] = (1.0 / U[i, i]) * (y[i] - sum)
            }

            return res
        }
    }
}