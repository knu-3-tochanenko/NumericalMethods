class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("<3")

            val random = Matrix(5)
            random.generateRandom()
            testMatrix(random, "RANDOM")

            val ok = Matrix(5)
            ok.generateOk()
            testMatrix(ok, "OK")

            val notok = Matrix(5)
            notok.generateNotOk()
            testMatrix(notok, "NOT OK")

        }

        fun testMatrix(matrix: Matrix, name: String) {
            print("\n\n$ANSI_GREEN------- $name -------$ANSI_RESET")
            matrix.regenerateWithResult(1.0, 2.0, 3.0, 0.0, 13.5)
            print(matrix)
            print("\n${ANSI_GREEN}Gauss")
            Gauss.solve(matrix).forEach { print("$ANSI_CYAN%.3f\t$ANSI_RESET".format(it)) }
            print("\n${ANSI_GREEN}Jacobi")
            Jacobi.solve(matrix, 0.0001).forEach { print("$ANSI_CYAN%.3f\t$ANSI_RESET".format(it)) }
            print("\n${ANSI_GREEN}Seidel")
            Seidel.solve(matrix, 0.0001).forEach { print("$ANSI_CYAN%.3f\t$ANSI_RESET".format(it)) }
        }
    }
}