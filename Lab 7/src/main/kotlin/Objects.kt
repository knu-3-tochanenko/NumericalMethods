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