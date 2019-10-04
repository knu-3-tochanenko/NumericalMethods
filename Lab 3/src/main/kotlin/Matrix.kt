class Matrix {
    val elements: Int
    private var matrix: Array<DoubleArray> = arrayOf()
    operator fun get(i: Int, j: Int): Double {
        checkBoundaries(i, j)
        return matrix[i][j]
    }

    operator fun set(i: Int, j: Int, value: Double) {
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

    constructor(elements: Int) {
        this.elements = elements
        matrix = Array(elements) { DoubleArray(elements) { 0.0 } }
    }

    constructor(matrix: Array<DoubleArray>) {
        this.elements = matrix.size
        for (i in 0 until this.elements)
            for (j in 0 until this.elements)
                this[i, j] = matrix[i][j]
    }

    fun print() {
        for (i in 0 until elements) {
            for (j in 0 until elements)
                print("${this[i, j]} ")
            println()
        }
    }
}