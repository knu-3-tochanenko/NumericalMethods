class Evenly {
    companion object {
        fun run() {
            val range = -3.0..3.0 step 0.1
            val range1 = -3.0..3.0 step 0.2
            val points1 = fillArray(range1) { x: Double -> f(x) }

            val lagrangePolynomial = Lagrange(points1.toTypedArray())
            printResult(
                "Lagrange Polynomial Interpolation ",
                lagrangePolynomial,
                range
            )
            val range2 = -3.0..3.0 step 0.1
            val points2 = fillArray(range2) { x: Double -> f(x) }

            val newtonPolynomial = NewtonPolynomial(points2.toTypedArray())
            printResult(
                "Newton Polynomial Interpolation ",
                newtonPolynomial,
                range
            )

            val cubicSpline = CubicSpline(points2.toTypedArray())
            printSplines(
                "Cubic Splines Interpolation ",
                cubicSpline,
                range
            )
        }
    }
}