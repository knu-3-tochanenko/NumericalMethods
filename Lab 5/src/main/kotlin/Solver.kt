import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.sqrt

class Solver {
    companion object {
        lateinit var vectors: Matrix
        lateinit var values: DoubleArray
        @JvmStatic
        fun solve(matrix: Matrix) {
            var S = Matrix(matrix)
            val res = DoubleArray(matrix.elements) { 0.0 }
            var M: Matrix

            var vectorMatrix = Matrix(matrix.elements)
            vectorMatrix.generateI()

            val precision = .1.pow(PRECISION)
            while (norm(S) > precision) {
                M = Matrix(S)

                for (i in 0 until M.elements)
                    M[i, i] = 0.0

                val (row, column) = maxCoordinate(M)

                if (row == column)
                    break

                val J = S.rotationMatrix(row, column)
                S = J * S * J.transpose()
                vectorMatrix *= J
            }

            vectors = vectorMatrix
            values = DoubleArray(matrix.elements)
            for (i in 0 until matrix.elements)
                values[i] = S[i, i]
        }

        private fun maxCoordinate(matrix: Matrix) : Pair<Int, Int> {
            var row = 0
            var column = 0
            var max = matrix[0, 0]
            for (i in 0 until matrix.elements)
                for (j in 0 until matrix.elements)
                    if (max.absoluteValue < matrix[i, j].absoluteValue) {
                        max = matrix[i, j]
                        row = i
                        column = j
                    }
            return row to column
        }

        private fun norm(matrix: Matrix): Double {
            var norm = 0.0
            for (i in 0 until matrix.elements)
                for (j in 0 until matrix.elements)
                    if (i != j)
                        norm += matrix[i, j] * matrix[i, j]
            return sqrt(norm)
        }
    }
}
