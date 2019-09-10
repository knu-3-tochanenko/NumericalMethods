import kotlin.math.pow

class Main {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            testBisection()
        }

        fun function(x: Float): Float = x.pow(3) + 8

        fun testBisection() {
            val bisection = Bisection(::function, 8)
            print("Result of bisection is ${bisection.calculate(-10F, 3F, 0)}")
        }
    }
}