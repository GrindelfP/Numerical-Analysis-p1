package to.deepstorage.numericMethodsPartOne

import java.awt.Color
import java.awt.Graphics
import javax.swing.JFrame

class Graph(
    private val function: (Double) -> Double
) : JFrame() {
    companion object {
        private const val WINDOW_WIDTH = 800
        private const val WINDOW_HEIGHT = 600
        private const val WINDOW_MARGIN = 50
        private const val WINDOW_SCALE = 50
    }

    override fun paint(g: Graphics) {
        super.paint(g)
        g.color = Color.BLACK
        // рисуем оси координат
        g.drawLine(WINDOW_MARGIN, WINDOW_HEIGHT / 2, WINDOW_WIDTH - WINDOW_MARGIN, WINDOW_HEIGHT / 2)
        g.drawLine(WINDOW_WIDTH / 2, WINDOW_MARGIN, WINDOW_WIDTH / 2, WINDOW_HEIGHT - WINDOW_MARGIN)
        // рисуем стрелки на концах осей
        g.drawLine(
            WINDOW_WIDTH - WINDOW_MARGIN - 10, WINDOW_HEIGHT / 2 - 5, WINDOW_WIDTH - WINDOW_MARGIN,
            WINDOW_HEIGHT / 2
        )
        g.drawLine(
            WINDOW_WIDTH - WINDOW_MARGIN - 10, WINDOW_HEIGHT / 2 + 5, WINDOW_WIDTH - WINDOW_MARGIN,
            WINDOW_HEIGHT / 2
        )
        g.drawLine(WINDOW_WIDTH / 2 - 5, WINDOW_MARGIN + 10, WINDOW_WIDTH / 2, WINDOW_MARGIN)
        g.drawLine(WINDOW_WIDTH / 2 + 5, WINDOW_MARGIN + 10, WINDOW_WIDTH / 2, WINDOW_MARGIN)
        // рисуем подписи к осям
        g.drawString("x", WINDOW_WIDTH - WINDOW_MARGIN + 5, WINDOW_HEIGHT / 2 + 15)
        g.drawString("y", WINDOW_WIDTH / 2 - 15, WINDOW_MARGIN - 5)
        // рисуем метки на осях
        for (i in -5..5) {
            g.drawLine(
                WINDOW_WIDTH / 2 + i * 50, WINDOW_HEIGHT / 2 - 5,
                WINDOW_WIDTH / 2 + i * 50, WINDOW_HEIGHT / 2 + 5
            )
            if (i != 0) {
                g.drawString(
                    i.toString(), WINDOW_WIDTH / 2 + i * 50 - 5,
                    WINDOW_HEIGHT / 2 + 20
                )
            }
        }
        for (i in -5..5) {
            g.drawLine(
                WINDOW_WIDTH / 2 - 5, WINDOW_HEIGHT / 2 + i * 50,
                WINDOW_WIDTH / 2 + 5, WINDOW_HEIGHT / 2 + i * 50
            )
            if (i != 0) {
                g.drawString(
                    (-i).toString(), WINDOW_WIDTH / 2 + 10,
                    WINDOW_HEIGHT / 2 + i * 50 + 5
                )
            }
        }

        // рисуем график функции y = x -4cos^2(x) +3
        g.color = Color.RED
        var x1 = -WINDOW_WIDTH.toDouble() / (2 * WINDOW_SCALE) // начальное значение x
        var y1 = function(x1) // начальное значение y
        for (i in WINDOW_MARGIN..WINDOW_WIDTH - WINDOW_MARGIN) {
            val x2 = x1 + 1.0 / WINDOW_SCALE // следующее значение x
            val y2 = function(x2) // следующее значение y
            // преобразуем координаты в пиксели и соединяем точки линией
            g.drawLine(
                WINDOW_WIDTH / 2 + (x1 * WINDOW_SCALE).toInt(),
                WINDOW_HEIGHT / 2 - (y1 * WINDOW_SCALE).toInt(),
                WINDOW_WIDTH / 2 + (x2 * WINDOW_SCALE).toInt(),
                WINDOW_HEIGHT / 2 - (y2 * WINDOW_SCALE).toInt()
            )
            x1 = x2
            y1 = y2
        }
    }
}
