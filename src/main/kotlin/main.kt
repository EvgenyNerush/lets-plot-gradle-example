// файл main.kt

import jetbrains.letsPlot.export.ggsave
import jetbrains.letsPlot.geom.geomLine
import jetbrains.letsPlot.geom.geomPoint
import jetbrains.letsPlot.geom.geomSmooth
import jetbrains.letsPlot.letsPlot

fun main() {
    // определяем "облако" из точек
    val xs = listOf(1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5)
    val ys = listOf(8, 7, 4, 5, 4, 3, 4, 3, 2, 1, 2)
    val zs = listOf(0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1)

    // готовим данные для letsPlot в виду key-value хранилища
    val data = mapOf<String, Any>("xvals" to xs, "yvals" to ys, "zvals" to zs)

    // график = данные + один слой + другой слой
    val fig_1 = letsPlot(data) +
            // здесь цвет - просто свойство точек
            geomPoint( color = "dark-green"
                     , size = 3.0
                     ) { x = "xvals"; y = "yvals" } +
            geomLine() { x = "xvals"; y = "yvals" }

    // сохраняем в файл
    ggsave(fig_1, "plot_1.png")

    // ещё график
    val fig_2 = letsPlot(data) +
            // а здесь цвет - эстетика, он зависит от данных
            geomPoint(size = 3.0) { x = "xvals"; y = "yvals"; color = "zvals"} +
            // рисует усреднённые данные и разброс
            geomSmooth() { x = "xvals"; y = "yvals"}

    ggsave(fig_2, "plot_2.png")

    println("bye!")
}
