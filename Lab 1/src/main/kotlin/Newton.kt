import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.system.measureTimeMillis

class Newton(
    val function: (x: Double) -> Double,
    val derivative: (x: Double) -> Double,
    val numberOfDigits: Int
) {
    private val precision: Double = 0.1.pow(numberOfDigits)

    fun calculate(start: Double): CalculationResult {
        var x = start
        var prev: Double
        var calculations = 0
        var xi = x - function(x) / derivative(x)
        val milliseconds = measureTimeMillis {
            while ((xi - x).absoluteValue > precision) {
                if (derivative(x).absoluteValue <= precision) {
                    calculations = -1
                    break
                }
                calculations++
                x = xi
                xi = x - function(x) / derivative(x)
            }
        }
        return CalculationResult(x, calculations, milliseconds)
    }
}