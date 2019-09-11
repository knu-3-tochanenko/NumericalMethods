import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.system.measureTimeMillis

class Bisection(
    var function: (x: Double) -> Double,
    var numberOfDigits: Int
) {
    private val precision: Double = 0.1.pow(numberOfDigits)

    fun calculate(startP: Double, endP: Double): CalculationResult {
        var mid: Double = (endP + startP) / 2
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
