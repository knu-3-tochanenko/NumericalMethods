import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.system.measureTimeMillis

class Relaxation(
    val function: (x: Double) -> Double,
    val derivative: (x: Double) -> Double,
    val numberOfDigits: Int
) {
    private val precision: Double = 0.1.pow(numberOfDigits)

    fun calculate(start: Double): CalculationResult {
        var x = start
        var calculations = 0
        var xi = x - function(x) / derivative(x)
        val milliseconds = measureTimeMillis {

        }
        return CalculationResult(x, calculations, milliseconds)
    }
}