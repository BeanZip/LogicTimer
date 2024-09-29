package Components

import java.awt.*
import java.awt.geom.Line2D
import java.time.LocalTime
import javax.swing.JPanel
import javax.swing.Timer
import kotlin.math.cos
import kotlin.math.sin

// Analog class extending a custom menu class and implementing the clock interface
open class Analog : Basic.menu(), clock {  // Assuming Clock is an interface and Basic.menu() is defined elsewhere
    private val clockRadius = 100
    private val clockCenterX = clockRadius + 10
    private val clockCenterY = clockRadius + 10  // Changed to maintain symmetry
    private var currentTime: LocalTime = LocalTime.now()
    private var timer: Timer? = null

    init {
        preferredSize = Dimension(220, 220)
        background = Color.WHITE
    }

    // Updates the current time
    override fun updatetime() {
        currentTime = LocalTime.now()
    }

    // Starts the clock by creating a timer that ticks every second
    override fun start() {
        timer = Timer(1000) {
            updatetime()
            repaint()
        }
        timer?.start()
    }

    // Stops the clock
    override fun stop() {
        timer?.stop()
    }

    // Resets the clock to midnight
    override fun reset() {
        stop()
        currentTime = LocalTime.MIDNIGHT
        repaint()
    }

    // Displays the current time as a string
    override fun displayTime(): String? {
        return currentTime.toString()
    }

    // Corrected method to `paintComponent` for custom painting
    fun paintComponent(g: Graphics?) {
        super.paintComponents(g)
        val g2 = g as Graphics2D
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        drawClockFace(g2)

        // Draw the clock hands based on the current time
        drawHands(g2)
    }

    // Draw the clock face with numbers
    private fun drawClockFace(g2: Graphics2D) {
        g2.color = Color.BLACK
        g2.drawOval(10, 10, 2 * clockRadius, 2 * clockRadius)  // Clock outline
        for (i in 1..12) {
            val angle = Math.toRadians(i * 30.0)
            val x = clockCenterX + (clockRadius * 0.85 * sin(angle)).toInt()
            val y = clockCenterY - (clockRadius * 0.85 * cos(angle)).toInt()
            g2.drawString(i.toString(), x - 5, y + 5)
        }
    }

    // Draw the clock hands based on the current time
    private fun drawHands(g2: Graphics2D) {
        // Get hour, minute, and second values
        val hour = currentTime.hour
        val minute = currentTime.minute
        val second = currentTime.second

        // Draw hour, minute, and second hands with different colors and lengths
        drawHand(g2, Math.toRadians((hour % 12) * 30.0 + minute * 0.5), length = 50.0, width = 4f)  // Hour hand
        drawHand(g2, Math.toRadians(minute * 6.0 + second * 0.1), length = 70.0, width = 3f)  // Minute hand
        drawHand(g2, Math.toRadians(second * 6.0), length = 90.0, width = 2f, Color.RED)  // Second hand
    }

    // Draw a single clock hand
    private fun drawHand(g2: Graphics2D, angle: Double, length: Double, width: Float, color: Color = Color.BLACK) {
        g2.color = color
        g2.stroke = BasicStroke(width)
        val x = clockCenterX + (length * sin(angle)).toInt()
        val y = clockCenterY - (length * cos(angle)).toInt()
        g2.draw(Line2D.Double(clockCenterX.toDouble(), clockCenterY.toDouble(), x.toDouble(), y.toDouble()))
    }
}