import java.io.File

infix fun Matrix.getFrom(name: String) {
    val file = File(name)
    file.forEachLine {
        val numbers = it.split(" ")
        if (numbers.isNotEmpty())
            for (i in 1 until numbers.size)
                this[numbers[i].toInt(), numbers[0].toInt()] = 1.0
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