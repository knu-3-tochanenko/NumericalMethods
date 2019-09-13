data class CalculationResult(
    val result: Double,
    val calculations: Int,
    val time: Long
) {
    fun isCalculated(): Boolean {
        return calculations > 0
    }
}

const val MAX_CALCULATIONS = 100_000