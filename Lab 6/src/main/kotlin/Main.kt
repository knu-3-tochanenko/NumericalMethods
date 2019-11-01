class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Love u to the end of the kus`mus` and back <3")
            println("i write this")

            val firstLine = Line(7.0, -10.0, 5.0)
            val secondLine = Line(2.0, -5.0, -1.0)
            val startPoint = Dot(10.0, -5.0)

            val solver = Solver(
                firstLine,
                secondLine,
                startPoint
            )

            val res = solver.getRes()
            val dots = solver.getDots()

            println("RES : x = ${res.x}, y = ${res.y}")
            for ((index, value) in dots.withIndex()) {
                println("DOT #${index} : x = ${value.x}, y = ${value.y}")
            }

            Visualizer.draw(firstLine, secondLine, res, dots)
        }
    }
}