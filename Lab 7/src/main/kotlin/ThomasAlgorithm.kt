class ThomasAlgorithm(private val matrix: Array<Array<Double>>) {
    fun getResult(): DoubleArray {
        val size = matrix.size
        var y = matrix[0][0]
        val a = DoubleArray(size) { 0.0 }
        val b = DoubleArray(size) { 0.0 }
        val x = DoubleArray(size) { 0.0 }

        a[0] = -matrix[0][1] / y
        b[0] = matrix[0][size - 1] / y

        for (i in 1 until size) {
            y = matrix[i][i] + matrix[i][i - 1] * a[i - 1]
            a[i] = -matrix[i][i + 1] / y
            b[i] = (matrix[i][size] - matrix[i][i - 1] * b[i - 1]) / y
        }

        x[size - 1] = b[size - 1]
        for (i in size - 2 downTo 0) {
            x[i] = a[i] * x[i + 1] + b[i]
        }
        return x
    }
}