package bus.console.view

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box

import tornadofx.px

class Styles : Stylesheet() {
    companion object {
    }

    init {
        label {
            padding = box(10.px)
            fontSize = 15.px
            fontWeight = FontWeight.BOLD
        }
    }
}