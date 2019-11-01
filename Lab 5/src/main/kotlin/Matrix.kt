import java.lang.IndexOutOfBoundsException

class Matrix(
    val elements: Int
) {
    var matrix: Array<Array<Double>> = arrayOf()
    operator fun get(i: Int, j: Int): Double {
        checkBoundaries(i, j)
        return matrix[i][j]
    }

    operator fun set(i: Int, j: Int, value: Double) {
        checkBoundaries(i, j)
        matrix[i][j] = value
    }

    init {
        for (i in 0 until elements) {
            var nextLine = arrayOf<Double>()
            for (j in 0 until elements)
                nextLine += 0.0
            matrix += nextLine
        }
    }

    private fun checkBoundaries(i: Int, j: Int) {
        if (i >= matrix.size || j >= matrix.size)
            throw IndexOutOfBoundsException(
                "Well. You can't do that. Index is out of boundaries.\n" +
                        "Got $i and $j, but maximum size is ${matrix.size}"
            )
    }

    constructor(copy: Matrix) : this(copy.elements) {
        for (i in 0 until copy.elements) {
            for (j in 0 until copy.elements)
                this.matrix[i][j] = copy[i, j]
        }
    }

    fun setElements(vararg values: kotlin.Number) {
        var i = 0
        var j = 0
        for (item in values) {
            this.matrix[i][j] = item.toDouble()
            if (j == this.elements - 1) {
                j = 0
                if (i == this.elements - 1) i = 0 else i++
            } else j++
        }
    }

    operator fun plus(matrix: Matrix): Matrix {
        require(this.elements == matrix.elements) { "${this.elements} != ${matrix.elements}" }
        val res = Matrix(matrix.elements)
        for (i in 0 until matrix.elements)
            for (j in 0 until matrix.elements)
                res[i, j] = matrix[i, j] + this[i, j]
        return res
    }

    operator fun minus(matrix: Matrix): Matrix {
        return this + ((-1.0) * matrix)
    }

    operator fun times(vector: DoubleArray): DoubleArray {
        require(this.elements == vector.size) { "${this.elements} != ${vector.size}" }
        val res = DoubleArray(this.elements) { 0.0 }
        for (i in 0 until this.elements)
            for (j in 0 until this.elements)
                res[i] += this[i, j] * vector[j]
        return res
    }

    operator fun times(matrix: Matrix): Matrix {
        require(this.elements == matrix.elements) { "${this.elements} != ${matrix.elements}" }
        val res = Matrix(matrix.elements)
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

    // Inverts only diagonal matrices!
    fun invert() {
        for (i in 0 until this.elements)
            matrix[i][i] = 1.0 / matrix[i][i]
    }

    fun getDiagonal(): Matrix {
        val matrix = Matrix(this)
        for (i in 0 until matrix.elements)
            for (j in 0 until matrix.elements)
                if (i != j)
                    matrix[i, j] = 0.0
        return matrix
    }

    fun copy(matrix: Matrix) {
        require(this.elements == matrix.elements) { "${this.elements} != ${matrix.elements}" }
        for (i in 0 until matrix.elements)
            for (j in 0 until matrix.elements)
                this[i, j] = matrix[i, j]
    }

    override operator fun equals(other: Any?): Boolean {
        if (other is Matrix) {
            require(this.elements == other.elements) { "${this.elements} != ${other.elements}" }
            for (i in 0 until elements)
                for (j in 0 until elements)
                    if (this[i, j] != other[i, j])
                        return false
            return true
        } else
            return false
    }

    fun getUpperTriangle(): Matrix {
        val res = Matrix(elements)
        for (i in 0 until (elements - 1))
            for (j in (i + 1) until elements)
                res[i, j] = this[i, j]
        return res
    }

    fun getLowerTriangle(): Matrix {
        val res = Matrix(elements)
        for (i in 1 until elements)
            for (j in 0 until i)
                res[i, j] = this[i, j]
        return res
    }


}