import java.util.*
import kotlin.math.round

fun Matrix.generateRandom() {
    val random = Random(System.currentTimeMillis())
    for (i in 0 until elements)
        for (j in 0 until elements)
            this.matrix[i][j] = random.nextDouble() * 10 * if (random.nextInt() % 2 == 0) -1 else 1
}

fun Matrix.generateOk() {
    generateRandom()
    var sum: Double
    for (i in 0 until elements) {
        sum = 0.0
        for (j in 0..elements)
            sum += matrix[i][j]
        matrix[i][i] += sum
    }
}

fun Matrix.generateNotOk() {
    for (i in 0 until elements)
        for (j in 0..elements)
        // i + j + 1 = (i + 1) + (j + 1) - 1 because numeration starts from 0
            this.matrix[i][j] += 1.0 / (i + j + 1)
}

fun Matrix.regenerateWithResult(vararg x: Double) {
    if (x.size < elements)
        throw IllegalArgumentException("Size of x vector is ${x.size}, but matrix size is $elements")
    for (i in 0 until elements) {
        matrix[i][elements] = 0.0
        for (j in 0 until elements)
            matrix[i][elements] += x[j] * matrix[i][j]
    }
}

fun Matrix.getLowerInverted() : Matrix {
    val lower = getLowerTriangle() + getDiagonal()
    val res = Matrix(elements)

    var sum: Double

    for (i in 0 until elements) {
        res[i, i] = 1 / lower[i, i]
        for (j in 0 until i) {
            sum = 0.0
            for (k in j until i)
                sum += lower[i, k] * res[k, j]
            res[i, j] = res[i, i] * (-sum)
        }
    }
    return res
}

fun print(matrix: Matrix) {
    for (i in 0 until matrix.elements) {
        print("\n")
        for (j in 0 until matrix.elements)
            print("%.3f\t".format(matrix[i, j]))
    }
}

fun print(array: DoubleArray) {
    print("\n")
    for (i in array)
        print("%.3f\t".format(i))
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
    for (i in 0 until matrix.elements)
        for (j in 0 until matrix.elements)
            res[i, j] = matrix[i, j] * this
    return res
}

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}