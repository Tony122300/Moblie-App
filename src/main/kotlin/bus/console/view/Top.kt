package bus.console.view

import tornadofx.*

class Top : View() {
    override val root = tabpane {
        tab<BusMenu>()

    }
}
