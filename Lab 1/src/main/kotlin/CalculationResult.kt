data class CalculationResult(
    val result: Double,
    val calculations: Int,
    val time: Long
) {
    fun isCalculated(): Boolean {
        return calculations > 0
    }
}