import jetbrains.letsPlot.export.ggsave
import jetbrains.letsPlot.geom.geomLine
import jetbrains.letsPlot.geom.geomPoint
import jetbrains.letsPlot.letsPlot
import kotlin.random.Random

fun main() {
    val n = 5000
    val gen = Random(12345) // seeded
    val xs = arrayListOf(1.0, 2  , 3, 4)
    val ys = arrayListOf(3.1, 1.7, 1, 2)

   val data = mapOf<String, Any>("x" to xs, "y" to ys)
    val fig = letsPlot(data) + geomPoint(
        color = "dark-green",
        size = 2.0
    ) { x = "x"; y = "y" }   + geomLine() { x = "x"; y = "y"}

    ggsave(fig, "LetsPlotExample.png")
    println("done!")
}
