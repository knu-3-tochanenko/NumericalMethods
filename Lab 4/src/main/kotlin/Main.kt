class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Love u sooooo much, my kitten. uwu")

            val matrix = Matrix(3)
            val b = doubleArrayOf(1.0, 1.0, 1.0)
            val x = doubleArrayOf(5.0, 7.0, 1.0)
            matrix.generateOk();
            matrix.regenerateWithResult(x, b)
            print(matrix, b)
            print("\n${ANSI_CYAN}Expected result :${ANSI_RESET}")
            print(x)

            print("\n\n${ANSI_YELLOW}Gauss method :${ANSI_RESET}")
            print(Gauss.solve(matrix, b))
            print("\n\n${ANSI_YELLOW}Jacobi method :${ANSI_RESET}")
            print(Jacobi.solve(matrix, b))
            print("\n\n${ANSI_YELLOW}Seidel method :${ANSI_RESET}")
            print(Seidel.solve(matrix, b))
        }
    }
}