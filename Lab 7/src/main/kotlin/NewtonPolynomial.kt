class NewtonPolynomial(private val dots: Array<Dot>) : Solver {
    override fun solve(): DoubleArray {
        val size = dots.size
        var res = DoubleArray(size) { 0.0 }
        val f = DoubleArray(size) { i -> dots[i].y }
        var product = doubleArrayOf(1.0)

        for (j in 0 until size)
            for (i in size - 1 downTo j+1)
                f[i] = (f[i] - f[i - 1]) / (dots[i].x - dots[i - j - 1].x)

        for (i in 0 until size) {
            res += product * f[i]
            product *= doubleArrayOf(1.0, -dots[i].x)
        }
        return res
    }
}