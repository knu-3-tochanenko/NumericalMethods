import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            testBisection(::function, 16, -10.0, 3.0)
            testBisection(::function, 5, -10.0, 3.0)
            testNewton(::trigonometricFunction, ::trigonometricDerivative, 12, 0.3)
            testRelaxation(::trigonometricFunction, ::trigonometricDerivative, 12, -0.9, 1.0)

            testBisection(::noAnswer, 4, 0.9, 3.0)
            testNewton(::noAnswer, ::noAnswerDerivative, 4, 3.0)
            testRelaxation(::noAnswer, ::noAnswerDerivative, 4, 0.9, 3.0)
        }

        private fun function(x: Double) = x.pow(3) - 8
        private fun derivative(x: Double): Double = 3 * x * x

        private fun trigonometricFunction(x: Double) = sin(x) + 0.5
        private fun trigonometricDerivative(x: Double) = cos(x)

        private fun noAnswer(x: Double) = x * x + 4
        private fun noAnswerDerivative(x: Double) = 2 * x

        private fun printResult(
            calculationResult: CalculationResult,
            precision: Int, method: String
        ) {
            val colorReset = "\u001B[0m"
            val colorGreen = "\u001B[32m"
            val colorYellow = "\u001B[33m"
            if (calculationResult.isCalculated())
                print(
                    "\nResult of " + colorGreen + method + colorReset + " method is " +
                            colorYellow + calculationResult.result + colorReset + "\n" +
                            "with precision of " + colorYellow + precision + colorReset + " digits.\n" +
                            "In " + colorYellow + calculationResult.calculations + colorReset + " calculations.\n" +
                            "In " + colorYellow + calculationResult.time + colorReset + " milliseconds.\n"
                )
            else
                print("\nAn error occurred while calculating using " +
                        colorGreen + method + colorReset + " method.\n" +
                        "Wasted " + colorYellow + calculationResult.time + colorReset +
                        " milliseconds on it! Absolutely barbaric!\n")
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

        private fun testNewton(
            function: (x: Double) -> Double,
            derivative: (x: Double) -> Double,
            precision: Int,
            start: Double
        ) {
            val newton = Newton(function, derivative, precision)
            val res = newton.calculate(start)
            printResult(res, precision, "Newton")
        }

        private fun testRelaxation(
            function: (x: Double) -> Double,
            derivative: (x: Double) -> Double,
            precision: Int,
            start: Double,
            end: Double
        ) {
            val newton = Relaxation(function, derivative, precision)
            val res = newton.calculate(start, end)
            printResult(res, precision, "Relaxation")
        }
    }
}