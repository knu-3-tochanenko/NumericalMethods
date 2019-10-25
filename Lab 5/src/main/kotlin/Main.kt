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
            print(solver.values)
            print("\n-----------\n")
            print(solver.vectors)
        }
    }
}