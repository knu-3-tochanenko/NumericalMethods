class Lagrange(private val dots: Array<Dot>) : Solver {
    override fun solve(): DoubleArray {
        val size = dots.size
        var res = DoubleArray(size) { 0.0 }
        for (i in dots.indices)
            res += getCoefficients(i)
        return res
    }

    private fun getCoefficients(index: Int) : DoubleArray {
        var array = DoubleArray(1) { 1.0 }
        var res = 1.0
        for (i in dots.indices) {
            if (i == index)
                continue
            val currentVal = doubleArrayOf(1.0, -dots[i].x)
            res *= dots[index].x - dots[i].x
            array *= currentVal
        }
        return array * (dots[index].y / res)
    }


}