import kotlin.math.pow

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            testBisection(::function, 12, -1000.0, 5.0)
            testBisection(::function, 4, -1000.0, 5.0)
            testNewton()
        }

        private fun function(x: Double) = x.pow(3) + 8

        private fun derivative(x: Double): Double = 3 * x * x

        private fun printResult(
            calculationResult: CalculationResult,
            precision: Int, method: String
        ) {
            val ANSI_RESET = "\u001B[0m"
            val ANSI_BLACK = "\u001B[30m"
            val ANSI_RED = "\u001B[31m"
            val ANSI_GREEN = "\u001B[32m"
            val ANSI_YELLOW = "\u001B[33m"
            val ANSI_BLUE = "\u001B[34m"
            val ANSI_PURPLE = "\u001B[35m"
            val ANSI_CYAN = "\u001B[36m"
            val ANSI_WHITE = "\u001B[37m"
            if (calculationResult.isCalculated())
                print(
                    "\nResult of " + ANSI_GREEN + method + ANSI_RESET + " method is " + ANSI_YELLOW + calculationResult.result + ANSI_RESET + "\n" +
                            "with precision of " + ANSI_YELLOW + precision + ANSI_RESET + " digits.\n" +
                            "In " + ANSI_YELLOW + calculationResult.calculations + ANSI_RESET + " calculations.\n" +
                            "In " + ANSI_YELLOW + calculationResult.time + ANSI_RESET + " milliseconds.\n"
                )
            else
                print("\nAn error occurred while calculating using $method method.\n")
        }

        private fun testBisection(
            function: (x: Double) -> Double,
            precision: Int,
            left: Double,
            right: Double
        ) {
            val bisection = Bisection(function, precision)
            val res = bisection.calculate(left, right)
            printResult(res, precision, "Bisection")
        }

        private fun testNewton() {
            val precision = 12
            val newton = Newton(::function, ::derivative, precision)
            val res = newton.calculate(124.7)
            printResult(res, precision, "Newton")
        }
    }
}