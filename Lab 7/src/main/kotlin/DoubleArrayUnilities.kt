operator fun DoubleArray.plus(array: DoubleArray): DoubleArray {
    val size = Math.max(this.size, array.size)
    val result = DoubleArray(size) { 0.0 }

    for (i in 1..this.size)
        result[size - i] += this[this.size - i]
    for (i in 1..array.size)
        result[size - i] += array[array.size - i]
    return result
}

operator fun DoubleArray.times(value: Double): DoubleArray {
    val result = DoubleArray(this.size) { 0.0 }
    for (i in this.indices)
        result[i] = this[i] * value
    return result
}

operator fun DoubleArray.times(array: DoubleArray): DoubleArray {
    val result = DoubleArray(this.size + array.size - 1) { 0.0 }
    for (i in this.indices)
        for (j in array.indices)
            result[i + j] += this[i] * array[j]
    return result
}

infix fun ClosedRange<Double>.step(step: Double): Iterable<Double> {
    require(start.isFinite())
    require(endInclusive.isFinite())
    require(step > 0.0) { "Step must be positive, was: $step." }
    val sequence = generateSequence(start) { previous ->
        if (previous == Double.POSITIVE_INFINITY) return@generateSequence null
        val next = previous + step
        if (next > endInclusive) null else next
    }
    return sequence.asIterable()
}

fun fillArray(range: Iterable<Double>, f: (Double) -> Double): MutableList<Dot> {
    val array = mutableListOf<Dot>()
    for (i in range) {
        array.add(Dot(i, f(i)))
    }
    return array

}

fun fillArrayPolynomial(range: Iterable<Double>, coef: DoubleArray): MutableList<Double> {
    val result = mutableListOf<Double>()
    for (i in range) {
        result.add(getPolynomialRoot(i, coef))
    }
    return result
}

fun getPolynomialRoot(x: Double, coef: DoubleArray): Double {
    var pow = coef.size - 1
    var result = 0.0
    for (i in coef.indices) {
        result += power(x, pow) * coef[i]
        pow--
    }
    return result
}

fun power(x: Double, pow: Int): Double {
    var res = 1.0
    for (i in 0 until pow)
        res *= x
    return res
}