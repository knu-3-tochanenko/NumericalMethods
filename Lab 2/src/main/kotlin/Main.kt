class Main {
    companion object {
        @JvmStatic fun main(args:Array<String>) {
            println("<3")

            val random = Matrix(3)
            random.generateRandom()
            testMatrix(random, "RANDOM")

            val ok = Matrix(3)
            ok.generateOk()
            testMatrix(ok, "OK")

            val notok = Matrix(3)
            notok.generateOk()
            testMatrix(notok, "NOT OK")

        }

        fun testMatrix(matrix: Matrix, name: String) {
            print("\n\n$ANSI_GREEN------- $name -------$ANSI_RESET")
            matrix.regenerateWithResult(1.0, 2.0, 3.0)
            print(matrix)
            print("\n${ANSI_GREEN}Gauss")
            Gauss.solve(matrix).forEach { print("$ANSI_CYAN%.3f\t$ANSI_RESET".format(it)) }
            print("\n${ANSI_GREEN}Jacobi")
            Jacobi.solve(matrix, 0.0001).forEach { print("$ANSI_CYAN%.3f\t$ANSI_RESET".format(it)) }
        }
    }
}