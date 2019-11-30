import java.lang.Math.sin

interface Solver {
    fun solve() : DoubleArray
}

fun f(x: Double) = x * x * sin(2 * x)