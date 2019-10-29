data class Line(
    var x: Double,
    var y: Double,
    var b: Double
) {
    constructor(line: Line) : this(line.x, line.y, line.b)
}

data class Dot(
    var x: Double,
    var y: Double
) {
    constructor(dot: Dot) : this(dot.x, dot.y)
}