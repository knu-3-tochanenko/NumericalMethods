import kotlin.math.min
import kotlin.math.max
import org.knowm.xchart.SwingWrapper
import org.knowm.xchart.XYChartBuilder

class Visualizer {
    companion object {
        @JvmStatic
        fun draw(
            firstLine: Line,
            secondLine: Line,
            res: Dot,
            dots: List<Dot>
        ) {
            val minInDotsX = dots.minBy { it.x }
            val maxInDotsX = dots.maxBy { it.x }
            val minInDotsY = dots.minBy { it.y }
            val maxInDotsY = dots.maxBy { it.y }
            val (xStart, xEnd) = Pair(min(res.x, minInDotsX?.x!!), max(res.x, maxInDotsX?.x!!))
            val (yStart, yEnd) = Pair(min(res.y, minInDotsY?.y!!), max(res.y, maxInDotsY?.y!!))

            // Create Chart
            val chart =
                XYChartBuilder()
                    .width(800)
                    .height(600)
                    .title("Computing ...")
                    .xAxisTitle("X")
                    .yAxisTitle("Y")
                    .build()

            chart.addSeries("NULL", doubleArrayOf(0.0), doubleArrayOf(0.0))

            chart.addSeries("First Line",
                doubleArrayOf(xStart, xEnd),
                doubleArrayOf(firstLine.getY(xStart), firstLine.getY(xEnd)))

            chart.addSeries("Second Line",
                doubleArrayOf(xStart, xEnd),
                doubleArrayOf(secondLine.getY(xStart), secondLine.getY(xEnd)))


            val drawnX = mutableListOf<Double>()
            drawnX.add(dots[0].x)
            val drawnY = mutableListOf<Double>()
            drawnY.add(dots[0].y)

            chart.addSeries("Dots",
                drawnX,
                drawnY
            )

            var sw = SwingWrapper(chart)
                sw.displayChart()

            for (i in 1 until dots.size) {
                Thread.sleep(SPEED)
                drawnX.add(dots[i].x)
                drawnY.add(dots[i].y)
                chart.updateXYSeries("Dots", drawnX, drawnY, null)
                sw.repaintChart()
            }

            val format = "%." + NUMBER_OF_DIGITS.toString() + "f"

            chart.title = "DONE x = ${format.format(res.x)}, y = ${format.format(res.y)}"
        }
    }
}