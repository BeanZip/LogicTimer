package Components

import java.text.SimpleDateFormat
import java.util.Date
import javax.swing.JLabel
import javax.swing.SwingConstants
import javax.swing.SwingUtilities
import kotlin.concurrent.timer

open class DigitalClock : Basic.menu() {
    fun setup(){
        val timeLabel = JLabel().apply {
            horizontalAlignment = SwingConstants.CENTER
            font = font.deriveFont(32f)
        }
        frame.add(timeLabel)
        timer(period = 1000){
            val CurrentTime = SimpleDateFormat("HH:mm:ss").format(Date())
            SwingUtilities.invokeLater{
                timeLabel.text = CurrentTime
            }
        }
    }
    fun interact(){
        Digital.addActionListener(){
            setup()
            SwingUtilities.updateComponentTreeUI(frame)
        }
    }
}