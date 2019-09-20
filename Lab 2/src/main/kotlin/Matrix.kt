import java.lang.IndexOutOfBoundsException
import java.util.*

const val ANSI_GREEN = "\u001B[32m"
const val ANSI_YELLOW = "\u001B[33m"
const val ANSI_RESET = "\u001B[0m"
const val ANSI_CYAN = "\u001B[36m"

class Matrix(
    val elements: Int
) {
    lateinit var matrix: Array<Array<Double>>
    operator fun get(i: Int, j: Int): Double {
        checkBoundaries(i, j)
        return matrix[i][j]
    }

    operator fun set(i: Int, j: Int, value: Double) {
        checkBoundaries(i, j)
        matrix[i][j] = value
    }

    private fun checkBoundaries(i: Int, j: Int) {
        if (i >= matrix.size || j > matrix.size)
            throw IndexOutOfBoundsException(
                "Well. You can't do that. Index is out of boundaries.\n" +
                        "Got $i and $j, but maximum size is ${matrix.size}"
            )
    }

    fun generateRandom() {
        matrix = arrayOf<Array<Double>>()
        val random = Random(System.currentTimeMillis())
        for (i in 0 until elements) {
            var nextLine = arrayOf<Double>()
            for (j in 0..elements)
                nextLine += random.nextDouble() * 10 * if (random.nextInt() % 2 == 0) -1 else 1
            matrix += nextLine
        }
    }

    fun generateOk() {
        generateRandom()
        var sum: Double
        for (i in 0 until elements) {
            sum = 0.0
            for (j in 0..elements)
                sum += matrix[i][j]
            matrix[i][i] += sum
        }
    }

    fun generateNotOk() {
        matrix = arrayOf<Array<Double>>()
        for (i in 0 until elements) {
            var nextLine = arrayOf<Double>()
            for (j in 0..elements)
            // i + j + 1 = (i + 1) + (j + 1) - 1 because numeration starts from 0
                nextLine += 1.0 / (i + j + 1)
            matrix += nextLine
        }
    }

    fun regenerateWithResult(vararg x: Double) {
        if (x.size < elements)
            throw IllegalArgumentException("Size of x vector is ${x.size}, but matrix size is $elements")
        for (i in 0 until elements) {
            matrix[i][elements] = 0.0
            for (j in 0 until elements)
                matrix[i][elements] += x[j] * matrix[i][j]
        }
    }
}

fun print(matrix: Matrix) {
    for (i in 0 until matrix.elements) {
        print("\n")
        for (j in 0 until matrix.elements)
            print("%.3f\t".format(matrix[i, j]))
        print("$ANSI_YELLOW---\t%.3f$ANSI_RESET".format(matrix[i, matrix.elements]))
    }
}
