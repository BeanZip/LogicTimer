package Components

import java.time.Clock

open class AnalogClock : Analog() {
    fun setup(){
        val clock: Analog = Analog()
        start()
        frame.add(clock)
        frame.pack()
        if(!frame.isVisible){
            SetVisible()
        }
    }
    fun interactable2() {
        Analog.addActionListener{
            setup()
        }
    }
}