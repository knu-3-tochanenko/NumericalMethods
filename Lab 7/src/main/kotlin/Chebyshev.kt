class Chebyshev {
    companion object {
        fun run() {
            val n = 30
            val roots = ChebyshevPolynomialRoots()
            val points = getDots(roots.getRoots(n)) { x: Double -> f(x) }
            val range = -1.0..1.0 step 0.05

            val lagrangePolynomial = Lagrange(points)
            printResult(
                "Lagrange Polynomial Interpolation ",
                lagrangePolynomial,
                range
            )

            val newtonPolynomial = NewtonPolynomial(points)
            printResult(
                "Newton Polynomial Interpolation ",
                newtonPolynomial,
                range
            )

            val cubicSplines = CubicSpline(points)
            printSplines(
                "Cubic Splines Interpolation ",
                cubicSplines,
                range
            )

            println("It works! ")
        }

        private fun getDots(x: DoubleArray, f: (Double) -> Double) =
            Array(x.size) { i -> Dot(x[i], f(x[i])) }
    }
}