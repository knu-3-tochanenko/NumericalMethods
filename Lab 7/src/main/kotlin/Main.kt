class Main {
    companion object {
        val MODE = false

        @JvmStatic
        fun main(args: Array<String>) {
            println("It works!")
            if (MODE)
                Evenly.run()
            else
                Chebyshev.run()
        }
    }
}