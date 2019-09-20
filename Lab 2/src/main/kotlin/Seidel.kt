import kotlin.math.sqrt

object Seidel {
    fun solve(matrix: Matrix, precision: Double): Array<Double> {
        val res: Array<Double> = Array(matrix.elements) { 0.0 }
        var norm = precision * precision * 10

        var subVector = Array(matrix.elements) { 0.0 }
        var iterations = 0
        while (sqrt(norm) > precision) {
            for (i in 0 until matrix.elements) {
                iterations++
                subVector[i] = res[i]
            }
            for (i in 0 until matrix.elements) {
                iterations++
                var sum = 0.0
                for (j in 0 until i)
                    sum += matrix[i, j] * res[j]
                for (j in i + 1 until matrix.elements)
                    sum += matrix[i, j] * subVector[j]
                res[i] = (matrix[i, matrix.elements] - sum) / matrix[i, i]
            }
            norm = 0.0
            for (i in 0 until matrix.elements) {
                iterations++
                norm += (res[i] - subVector[i]) * (res[i] - subVector[i])
            }
        }
        print(" : ($iterations)$ANSI_RESET\n")
        return res
    }
}