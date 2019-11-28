data class Line(
    var x: Double,
    var y: Double,
    var c: Double
) {
    constructor(line: Line) : this(line.x, line.y, line.c)

    fun getY(a: Double): Double {
        return (-c - a * x) / y
    }
}

data class Dot(
    var x: Double,
    var y: Double
) {
    constructor(dot: Dot) : this(dot.x, dot.y)
}

fun Array<Dot>.split(): Pair<DoubleArray, DoubleArray> {
    val xArray = DoubleArray(this.size) { 0.0 }
    val yArray = DoubleArray(this.size) { 0.0 }

    for (i in this.indices) {
        xArray[i] = this[i].x
        yArray[i] = this[i].y
    }

    return xArray to yArray
}