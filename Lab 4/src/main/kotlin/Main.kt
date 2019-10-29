class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val matrix = Matrix(3)
            val b = doubleArrayOf(1.0, 6.0, 4.0)
            val x = doubleArrayOf(1.0, 5.0, 1.0)
            matrix.generateOk()
            matrix.regenerateWithResult(x, b)
//            matrix.setElements(
//                1, 1, 1,
//                4, 3, -1,
//                3, 5, 3
//            )
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