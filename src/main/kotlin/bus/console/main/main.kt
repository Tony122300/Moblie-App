package bus.console.main
import mu.KotlinLogging
import bus.console.models.BusModel

private val logger = KotlinLogging.logger {}
val buses = ArrayList<BusModel>()
var bus = BusModel()
fun main(args: Array<String>) {
    println("bus app")

    var input: Int

    do {
        input = menu()
        when(input) {
            0 -> addBus() //secret menu
            1 -> println("find bus by route")
            2 -> println("find bus by origin and destination")
            3 -> println("Buy ticket")
            4 -> searchBusByRoute()
            5 -> listBusRoutes()
            6 -> println("find timetable")
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    println("Shutting Down bus app Console App" )
}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. find bus by route ")
    println(" 2. find bus by origin and destination ")
    println(" 3. Buy ticket ")
    println(" 4. search bus by routes ")
    println(" 5. list all routes ")
    println(" 6. find timetable ")
    println("-1. Exit")
    println()
    print("Enter an integer : ")
    input = readLine()!!
    option = if (input.toIntOrNull() != null && !input.isEmpty())
        input.toInt()
    else
        -9
    return option
}

fun listBusRoutes(){
    println("list of bus routes")
    buses.forEach { logger.info("${it}") }
}



fun addBus(){
    println("add bus")
    println()
    print("Enter bus route")
    bus.route = Integer.valueOf(readLine())
    print("Enter bus origin")
    bus.origin = readLine()!!
    print("Enter bus destination")
    bus.destination = readLine()!!
    print("Enter bus time of departure")
    bus.timeLeave = Integer.valueOf(readLine())
    print("Enter bus time of arrival")
    bus.timeArrive = Integer.valueOf(readLine())
    if(bus.route !=null && bus.origin.isNotEmpty() && bus.destination.isNotEmpty() && bus.timeArrive != null && bus.timeLeave != null){
        buses.add(bus.copy())


    }
}

fun searchBusByRoute(){
    println("Searching bus by route Number")
    println()

}