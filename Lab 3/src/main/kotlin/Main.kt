const val PRECISION = 0.0001

class Main {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            println("Million kisses <3")
            val rank = PageRank(5, "./src/main/kotlin/data.dat")
            println(rank.getRank(0))
            println(rank.getRank(1))
            println(rank.getRank(2))
            println(rank.getRank(3))
        }
    }
}