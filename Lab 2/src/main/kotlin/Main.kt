class Main {
    companion object {
        @JvmStatic fun main(args:Array<String>) {
            println("<3")

            println("\n$ANSI_GREEN----- Gauss. Random -----$ANSI_RESET")
            val random = Matrix(3)
            random.generateRandom()
            random.regenerateWithResult(1.0, 2.0, 3.0)
            Gauss.solve(random).forEach { print("$ANSI_CYAN%.3f\t$ANSI_RESET".format(it)) }
            print(random)

            println("\n$ANSI_GREEN----- Gauss. Ok -----$ANSI_RESET")
            val ok = Matrix(3)
            ok.generateOk()
            ok.regenerateWithResult(1.0, 2.0, 3.0)
            Gauss.solve(ok).forEach { print("$ANSI_CYAN%.3f\t$ANSI_RESET".format(it)) }
            print(ok)

            println("\n$ANSI_GREEN----- Gauss. NotOk -----$ANSI_RESET")
            val notok = Matrix(3)
            notok.generateOk()
            notok.regenerateWithResult(1.0, 2.0, 3.0)
            Gauss.solve(notok).forEach { print("$ANSI_CYAN%.3f\t$ANSI_RESET".format(it)) }
            print(notok)
        }
    }
}