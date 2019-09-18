import java.lang.IndexOutOfBoundsException
import java.util.*

class Matrix(
    val matrix: Array<Array<Double>>,
    val vector: Array<Double>
) {
    fun get(i: Int, j: Int): Double {
        checkBoundaries(i, j)
        return matrix[i][j]
    }

    fun set(i: Int, j: Int, value: Double) {
        checkBoundaries(i, j)
        matrix[i][j] = value
    }

    private fun checkBoundaries(i: Int, j: Int) {
        if (i >= matrix.size || j >= matrix.size)
            throw IndexOutOfBoundsException(
                "Well. You can't do that. Index is out of boundaries.\n" +
                        "Got $i and $j, but maximum size is ${matrix.size}"
            )
    }

    fun generateRandom(elements: Int) {
        val random = Random(System.currentTimeMillis())
        for (i in 0 until elements)
            for (j in 0 until elements)
                matrix[i][j] = random.nextDouble()
    }

    fun generateOk(elements: Int) {
        generateRandom(elements)
        var sum: Double
        for (i in 0 until elements) {
            sum = 0.0
            for (j in 0 until elements)
                sum += matrix[i][j]
            matrix[i][i] += sum
        }
    }

    fun generateNotOk(elements: Int) {
        for (i in 0 until elements)
            for (j in 0 until elements)
            // i + j + 1 = (i + 1) + (j + 1) - 1 because numeration starts from 0
                matrix[i][j] = 1.0 / (i + j + 1)
    }
}