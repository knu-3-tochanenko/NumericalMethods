import kotlin.math.pow

class Seidel {
    companion object {
        @JvmStatic
        fun solve(matrix: Matrix, b: DoubleArray): DoubleArray {
            val N = matrix.getLowerInverted()
            val M = (-1.0) * matrix.getUpperTriangle()

            val precision = 0.1.pow(PRECISION)
            var x = DoubleArray(b.size) { 0.0 }
            var xNew = x

            do {
                x = xNew
                xNew = N * (b + M * x)
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