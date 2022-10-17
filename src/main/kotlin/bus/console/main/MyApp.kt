package bus.console.main

import bus.console.view.MainView
import bus.console.view.Styles
import javafx.stage.Stage
import tornadofx.App

class MyApp: App(MainView::class, Styles::class){
    override fun start(stage: Stage){
        with(stage){
            width = 600.0
            height = 670.0
        }
        super.start(stage)
    }
}