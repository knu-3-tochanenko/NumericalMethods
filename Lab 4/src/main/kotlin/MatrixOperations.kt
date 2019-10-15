import kotlin.math.round

operator fun Matrix.plus(matrix: Matrix): Matrix {
    require(this.elements == matrix.elements) { "${this.elements} != ${matrix.elements}" }
    val res = Matrix(matrix.elements)
    res.generateEmpty()
    for (i in 0 until matrix.elements)
        for (j in 0 until matrix.elements)
            res[i, j] = matrix[i, j] + this[i, j]
    return res
}

operator fun Matrix.minus(matrix: Matrix): Matrix {
    return this + ((-1.0) * matrix)
}

operator fun DoubleArray.minus(array: DoubleArray): DoubleArray {
    require(this.size == array.size) { "${this.size} != ${array.size}" }

    val res = DoubleArray(this.size)
    for (i in this.indices)
        res[i] = this[i] - array[i]
    return res
}

operator fun DoubleArray.plus(array: DoubleArray): DoubleArray {
    require(this.size == array.size) { "${this.size} != ${array.size}" }

    val res = DoubleArray(this.size)
    for (i in this.indices)
        res[i] = this[i] + array[i]
    return res
}

operator fun Double.times(matrix: Matrix): Matrix {
    val res = Matrix(matrix.elements)
    res.generateEmpty()
    for (i in 0 until matrix.elements)
        for (j in 0 until matrix.elements)
            res[i, j] = matrix[i, j] * this
    return res
}

operator fun Matrix.times(vector: DoubleArray): DoubleArray {
    require(this.elements == vector.size) { "${this.elements} != ${vector.size}" }
    val res = DoubleArray(this.elements) { 0.0 }
    for (i in 0 until this.elements)
        for (j in 0 until this.elements)
            res[i] += this[i, j] * vector[j]
    return res
}

operator fun Matrix.times(matrix: Matrix): Matrix {
    require(this.elements == matrix.elements) { "${this.elements} != ${matrix.elements}" }
    val res = Matrix(matrix.elements)
    res.generateEmpty()
    var value: Double
    for (i in 0 until matrix.elements)
        for (j in 0 until matrix.elements) {
            value = 0.0
            for (k in 0 until matrix.elements)
                value += this[i, k] * matrix[k, j]
            res[i, j] = value
        }
    return res
}

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}

// Inverts only diagonal matrices!
fun Matrix.invert() {
    for (i in 0 until this.elements)
        matrix[i][i] = 1 / matrix[i][i]
}

fun Matrix.getDiagonal(): Matrix {
    val matrix = Matrix(this)
    for (i in 0 until matrix.elements)
        for (j in 0 until matrix.elements)
            if (i != j)
                matrix[i, j] = 0.0
    return matrix
}

fun Matrix.getB(): DoubleArray {
    val b = DoubleArray(this.elements)
    for (i in 0 until this.elements)
        b[i] = this[i, this.elements]
    return b
}

fun Matrix.copy(matrix: Matrix) {
    require(this.elements == matrix.elements) { "${this.elements} != ${matrix.elements}" }
    for (i in 0 until matrix.elements)
        for (j in 0..matrix.elements)
            this[i, j] = matrix[i, j]
}