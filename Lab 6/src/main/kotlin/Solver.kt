import kotlin.math.pow
import kotlin.math.sqrt

class Solver(
    var firstLine: Line,
    var secondLine: Line,
    var startingDot: Dot
) {
    private var res = Dot(startingDot)
    private var dots = mutableListOf(startingDot)

    init {
        var nextDot = Dot(startingDot)
        var dot = Dot(startingDot)
        var x: Double
        var y: Double

        var isFirst = true

        do {
            dots.add(Dot(dot))

            dot.x = nextDot.x
            dot.y = nextDot.y
            nextDot.x = calcX(
                dot,
                if (isFirst) firstLine else secondLine
            )
            nextDot.y = calcY(
                dot,
                if (isFirst) firstLine else secondLine
            )

            isFirst = !isFirst
        } while (norm(dot, nextDot) > PRECISION)

        res = Dot(dot)
    }

    private fun calcX(dot: Dot, line: Line): Double {
        return (-1.0) *
                (dot.x * line.x + dot.y * line.y + line.c) / (line.x.pow(2) + line.y.pow(2)) *
                line.x + dot.x
    }

    private fun calcY(dot: Dot, line: Line): Double {
        return (-1.0) *
                (dot.x * line.x + dot.y * line.y + line.c) / (line.x.pow(2) + line.y.pow(2)) *
                line.y + dot.y
    }

    private fun norm(firstDot: Dot, secondDot: Dot): Double {
        return sqrt((secondDot.x - firstDot.x).pow(2) + (secondDot.y - firstDot.y).pow(2))
    }

    fun getRes(): Dot {
        return res
    }

    fun getDots(): List<Dot> {
        return dots
    }
}