import kotlin.math.pow

class Jacobi {
    companion object {
        @JvmStatic
        fun solve(matrix: Matrix): DoubleArray {
            val N = matrix.getDiagonal()
            var M = Matrix(matrix - N)
            N.invert()
            val b = matrix.getB()

            val precision = 0.1.pow(PRECISION)
            var x = DoubleArray(b.size) { 0.0 }
            var xNew = x

            do {
                x = xNew
//                xNew = N * M * x - N * b      // Teacher's way
                xNew = N * (b + M * x)          // Book's way
            } while (norm(xNew, x) > precision)

            return xNew
        }

        private fun norm(v1: DoubleArray, v2: DoubleArray): Double {
            var norm = 0.0
            for (i in v1.indices)
                norm += (v1[i] - v2[i]).pow(2)
            return norm
        }
    }
}