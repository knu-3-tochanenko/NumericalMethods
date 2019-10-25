class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print("It works!")

            val matrix = Matrix(5)
            matrix.generateSymmetric()
            print(matrix)

            val solver = Solver()
            solver.solve(matrix)

            print("\n\nEigen values :${ANSI_CYAN}")
            print(solver.values)
            print("\n\n${ANSI_RESET}Eigen vectors :${ANSI_CYAN}")
            print(solver.vectors)
            print(ANSI_RESET)
        }
    }
}