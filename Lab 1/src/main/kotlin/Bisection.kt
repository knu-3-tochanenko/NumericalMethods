import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.system.measureTimeMillis

class Bisection(
    var function: (x: Double) -> Double,
    private var numberOfDigits: Int
) {
    private val precision: Double = 0.1.pow(numberOfDigits + 1)

    fun calculate(startP: Double, endP: Double): CalculationResult {
        var mid: Double = (endP + startP) / 2
        var start = startP
        var end = endP
        var calculations = 0
        val milliseconds = measureTimeMillis {
            while ((end - start).absoluteValue > precision) {
                if (calculations == MAX_CALCULATIONS) {
                    calculations = -1
                    break
                }
                calculations++
                mid = (end + start) / 2
                if (function(mid).absoluteValue <= precision)
                    break
                if (function(mid) * function(start) < 0)
                    end = mid
                else if (function(mid) * function(end) < 0)
                    start = mid
                else {
                    calculations = -1
                    break
                }
            }
        }
        if (function(mid).absoluteValue > precision)
            calculations = -1
        return CalculationResult(mid, calculations, milliseconds)
    }
}
