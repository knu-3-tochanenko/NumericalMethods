import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.sign
import kotlin.system.measureTimeMillis

class Relaxation(
    val function: (x: Double) -> Double,
    val derivative: (x: Double) -> Double,
    numberOfDigits: Int
) {
    private val precision: Double = 0.1.pow(numberOfDigits + 1)

    fun calculate(start: Double, end: Double): CalculationResult {
        var calculations = 0
        var x: Double
        var xi = 0.0
        val milliseconds = measureTimeMillis {
            var max = derivative(start)
            var min = derivative(start)
            var it = start
            while (it <= end) {
                if (derivative(it) < min)
                    min = derivative(it)
                if (derivative(it) > max)
                    max = derivative(it)
                it += 0.01
            }
            val lambda = 2 / (min + max)
            x = (start + end) / 2
            xi = x - lambda * function(x)
            while ((xi - x).absoluteValue > precision) {
                if (calculations == MAX_CALCULATIONS) {
                    calculations = -1
                    break
                }
                x = xi
                xi = x - lambda * function(x)
                calculations++
            }
        }
        // If method was unable to find result
        if (xi.isNaN() || xi.isInfinite())
            calculations = -1
        return CalculationResult(xi, calculations, milliseconds)
    }
}