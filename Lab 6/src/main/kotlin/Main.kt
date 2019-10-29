class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Love u to the end of the kus`mus` and back <3")
            println("i write this")

            val solver = Solver(
                Line(1.0, -1.0, 0.0),
                Line(6.0, 3.0, -18.0),
                Dot(3.0, 5.0)
            )

            val res = solver.getRes()
            val dots = solver.getDots()

            println("RES : x = ${res.x}, y = ${res.y}")
            for ((index, value) in dots.withIndex()) {
                println("DOT #${index} : x = ${value.x}, y = ${value.y}")
            }
        }
    }
}