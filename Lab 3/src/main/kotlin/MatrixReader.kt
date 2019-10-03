import java.io.File

infix fun Matrix.getFrom(name: String) {
    val file = File(name)
    file.forEachLine {
        val (startString, endString) = it.split(" ")
        val (start, end) = Pair(startString.toInt(), endString.toInt())
        this[end, start] = 1.0
    }
    normalize()
}

fun Matrix.normalize() {
    var sum: Double
    for (j in 0 until this.elements) {
        sum = 0.0
        for (i in 0 until this.elements)
            sum += this[i, j]
        if (sum > 0.0)
            for (i in 0 until this.elements)
                this[i, j] /= sum
    }
}