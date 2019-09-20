import kotlin.math.absoluteValue

object Jacobi {
    fun solve(matrix: Matrix, precision: Double): Array<Double> {
        val res: Array<Double> = Array(matrix.elements) { 0.0 }
        var subVector = Array(matrix.elements) { 0.0 }
        var norm = precision * 10
        var iterations = 0
        while (norm > precision) {
            for (i in 0 until matrix.elements) {
                iterations++
                subVector[i] = matrix[i, matrix.elements]
                for (j in 0 until matrix.elements) {
                    if (i != j)
                        subVector[i] -= matrix[i, j] * res[j]
                }
                subVector[i] /= matrix[i, i]
            }
            norm = (res[0] - subVector[0]).absoluteValue
            for (i in 0 until matrix.elements) {
                iterations++
                if ((res[i] - subVector[i]).absoluteValue > norm)
                    norm = (res[i] - subVector[i]).absoluteValue
                res[i] = subVector[i]
            }
        }
        print(" : ($iterations)$ANSI_RESET\n")
        return res
    }
}