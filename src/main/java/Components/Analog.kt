package Components

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.awt.geom.Line2D
import java.time.LocalTime
import javax.swing.Timer
import kotlin.math.cos
import kotlin.math.sin

open class Analog : Basic.menu(), clock {
    private val clockRadius = 100
    private val clockCenterX = clockRadius + 10
    private val clockCenterY = clockRadius - 10
    private var currentTime: LocalTime = LocalTime.now()
    private var timer: Timer? = null

    init{
        preferredSize = Dimension(220,220)
        background = Color.WHITE
    }
    override fun updatetime() {
        currentTime = LocalTime.now()
    }

    override fun start() {
        timer = Timer(1000){
            updatetime()
            repaint()
        }
        timer?.start()
    }

    override fun stop(){
        timer?.stop()
    }

    override fun reset() {
        stop()
        currentTime = LocalTime.MIDNIGHT
        repaint()
    }

    override fun displayTime(): String? {
        return currentTime.toString()
    }

    override fun paintComponents(g: Graphics?) {
        super.paintComponents(g)
        val g2 = g as Graphics2D
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        drawClockFace(g2)
    }

    private fun drawClockFace(g2: java.awt.Graphics2D) {
        g2.color = Color.BLACK
        g2.drawOval(10,10,2 * clockRadius, 2 * clockRadius)
        for ( i in 1..12){
            val angle = Math.toRadians(i * 30.0)
            val x = clockCenterX + (clockRadius * 0.85 * sin(angle)).toInt()
            val y = clockCenterY - (clockRadius * 0.85 * cos(angle)).toInt()

            g2.drawString(i.toString(), x - 5, y + 5)
        }
    }

    private fun drawHand(g2: Graphics2D, angle: Double, length: Double,width: Float,color: Color = Color.BLACK) {
        g2.color = color
        g2.stroke = java.awt.BasicStroke(width)
        val x = clockCenterX + (length * sin(angle)).toInt()
        val y = clockCenterY - (length * cos(angle)).toInt()
        g2.draw(Line2D.Double(clockCenterX.toDouble(),clockCenterY.toDouble(),x.toDouble(),y.toDouble()))
    }
}