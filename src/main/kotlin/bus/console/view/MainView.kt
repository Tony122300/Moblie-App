package bus.console.view
import javafx.scene.layout.BorderPane
import tornadofx.*

class MainView : View("Bus App") {
    override val root: BorderPane = borderpane {
        label(title)
            top {
            }
        top(Top::class)
    }
}

