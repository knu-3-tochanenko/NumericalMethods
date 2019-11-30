import kotlin.math.PI
import kotlin.math.cos

class ChebyshevPolynomialRoots {
    fun getRoots(n: Int): DoubleArray {
        val result = DoubleArray(n) { 0.0 }
        for (i in 0 until n) {
            result[i] = cos(PI * (i + 0.5) / n.toDouble())
        }
        result.sort()
        return result
    }
}