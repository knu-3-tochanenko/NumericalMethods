class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Love u sooooo much, my kitten. uwu")

            val matrix = Matrix(3)
            matrix.setElements(
                10.0, 0.0, 5.0,
                1.0, 5.0, 0.0,
                5.0, 10.0, 30.0
            )
            val b = doubleArrayOf(10.5, 16.0, 38.0)
            print("${ANSI_YELLOW}Calculated manually (on paper) :" +
                    "${ANSI_GREEN}\n1.000\t3.000\t0.100${ANSI_RESET}")
            print("\n\n${ANSI_YELLOW}Gauss method :${ANSI_RESET}")
            print(Gauss.solve(matrix, b))
            print("\n\n${ANSI_YELLOW}Jacobi method :${ANSI_RESET}")
            print(Jacobi.solve(matrix, b))
            print("\n\n${ANSI_YELLOW}Seidel method :${ANSI_RESET}")
            print(Seidel.solve(matrix, b))
        }
    }
}