import kotlin.math.absoluteValue
import kotlin.math.pow

class Bisection(
    var function: (x: Float) -> Float,
    var numberOfDigits: Int
) {
    private val precision: Float = 0.1.pow(numberOfDigits.toDouble()).toFloat()
    fun calculate(start: Float, end: Float, numberOfSteps: Int): Float {
        val mid = (start + end) / 2

        println("Operation #$numberOfSteps: Calculating between $start and $end. Function value is ${function(mid)}")
        val functionValue = function(mid)
        return when {
            functionValue.absoluteValue <= precision -> mid
            functionValue > 0 -> calculate(start, mid, numberOfSteps + 1)
            else -> calculate(mid, end, numberOfSteps + 1)
        }
    }
}