import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.system.measureTimeMillis

class Bisection(
    var function: (x: Float) -> Float,
    var numberOfDigits: Int
) {
    private val precision: Float = 0.1f.pow(numberOfDigits)

    fun calculate(startP: Float, endP: Float): CalculationResult {
        var mid: Float = (endP + startP) / 2
        var start = startP
        var end = endP
        var calculations = 0
        val milliseconds = measureTimeMillis {
            while ((end - start).absoluteValue > precision) {
                calculations++
                mid = (end + start) / 2
                if (function(mid).absoluteValue <= precision)
                    break
                if (function(mid) > 0)
                    end = mid
                else
                    start = mid
            }
        }
        return CalculationResult(mid, calculations, milliseconds)
    }
}

data class CalculationResult(
    val result: Float,
    val calculations: Int,
    val time: Long
)