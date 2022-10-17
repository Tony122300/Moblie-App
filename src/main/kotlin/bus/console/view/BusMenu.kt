package bus.console.view

import tornadofx.*

class BusMenu : View("Bus Menu") {
    override val root = borderpane {
        left = vbox {

            button("Add bus") {
                spacing = 8.00
                setOnAction {
                }
            }

        }
    }
}
