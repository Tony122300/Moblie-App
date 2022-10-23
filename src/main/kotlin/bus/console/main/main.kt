package bus.console.main
import bus.console.Controller.BusController
import mu.KotlinLogging
import bus.console.models.BusModel
import bus.console.Database.Database
import bus.console.models.BusMemStore
import bus.console.views.BusView
import kotlin.time.Duration.Companion.hours
import kotlin.time.hours


private val logger = KotlinLogging.logger {}
//val buses = ArrayList<BusModel>()
val buses = BusMemStore()
val busView = BusView()
val bus = BusModel()
fun main(args: Array<String>) {

    println("bus app")
    BusController().start()

}
