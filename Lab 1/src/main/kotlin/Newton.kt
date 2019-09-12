import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.system.measureTimeMillis

class Newton(
    val function: (x: Double) -> Double,
    val derivative: (x: Double) -> Double,
    numberOfDigits: Int
) {
    private val precision: Double = 0.1.pow(numberOfDigits + 1)

    fun calculate(start: Double): CalculationResult {
        var x = start
        var calculations = 0
        var xi = x - function(x) / derivative(x)
        val milliseconds = measureTimeMillis {
            while ((xi - x).absoluteValue > precision) {
                if (calculations == MAX_CALCULATIONS) {
                    calculations = -1
                    break
                }
                if (derivative(x).absoluteValue <= precision) {
                    if ((xi - x).absoluteValue > precision)
                        calculations = -1
                    break
                }
                calculations++
                x = xi
                xi = x - function(x) / derivative(x)
            }
        }
        // If method was unable to find result
        if (function(x).absoluteValue > precision)
            calculations = -1
        return CalculationResult(x, calculations, milliseconds)
    }
}