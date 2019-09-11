import kotlin.math.pow

class Main {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            testBisection()
            testNewton()
        }

        fun function(x: Double): Double = x.pow(3) + 8

        fun derivative(x: Double): Double = 3 * x * x

        fun testBisection() {
            val bisection = Bisection(::function, 12)
            val res = bisection.calculate(-1000.0, 3.0)
            print("\nResult of bisection is ${res.result}.\n" +
                    "In ${res.calculations} calculations in ${res.time} milliseconds\n")
        }

        fun testNewton() {
            val newton = Newton(::function, ::derivative, 12)
            val res = newton.calculate(124.7)
            print("\nResult of newton is ${res.result}.\n" +
                    "In ${res.calculations} calculations in ${res.time} milliseconds\n")
        }
    }
}