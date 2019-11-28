import org.knowm.xchart.SwingWrapper
import org.knowm.xchart.XYChartBuilder

fun printResult(name: String, solver: Solver, range: Iterable<Double>) {

    // Create Chart

    val dots = fillArray(range) { x: Double -> f(x) }.toTypedArray()
    val (x1Data, y1Data) = dots.split()
    val y2Data = fillArrayPolynomial(range, solver.solve()).toDoubleArray()
    val chart =
        XYChartBuilder().width(600).height(400).title(name).xAxisTitle("X").yAxisTitle("Y").build()

    chart.addSeries(
        "f1(x)",
        x1Data, y1Data
    )

    chart.addSeries(
        "f2(x)",
        x1Data, y2Data
    )

    val sw = SwingWrapper(chart)

    sw.displayChart()
}

fun printSplines(name: String, method: CubicSpline, range: Iterable<Double>) {
    // Create Chart

    val points = fillArray(range) { x: Double -> f(x) }.toTypedArray()
    method.printResults(range, points)

}