class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Love u sooooo much, my kitten. uwu")

            val matrix = Matrix(3)
            matrix.generateWithValues(
                1.0, 2.0, 2.0, 3.0,
                4.0, 4.0, 2.0, 6.0,
                4.0, 6.0, 4.0, 10.0
            )
            print(Jacobi.solve(matrix))
            print(matrix)
        }
    }
}