class Main {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            println("Million kisses <3")
            val rank = PageRank(ELEMENTS, "./src/main/kotlin/data.dat")
            rank.printRanks()
            rank.printMax()
        }
    }
}