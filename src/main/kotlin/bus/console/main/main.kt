package bus.console.main
import mu.KotlinLogging
import bus.console.models.BusModel
import bus.console.Database.Database
import kotlin.time.Duration.Companion.hours
import kotlin.time.hours

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
            5 -> println(listBuses())
            6 -> println("find timetable")
            7 -> deleteBus()
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

fun listBuses():List<BusModel>{
    val conn = Database().conn
    val resultSet = conn.createStatement().executeQuery("SELECT `BusID`, `Route`, `Origin`, `Destination`, `Departuretime`, `arrivaltime` FROM `businfo` WHERE 1")
    val busModels = ArrayList<BusModel>()
    while(resultSet.next()){
        val BusID = resultSet.getInt("busID")
        val Route = resultSet.getInt("Route")
        val Origin = resultSet.getString("Origin")
        val Destination = resultSet.getString("Destination")
        val Departuretime = resultSet.getInt("Departuretime")
        val arrivaltime = resultSet.getInt("arrivaltime")
        val bus = BusModel(BusID,Route,Origin,Destination,Departuretime,arrivaltime)
        busModels.add(bus)
    }
    resultSet.close()
    conn.close()
    return busModels
}

fun addBus(){
    val conn = Database().conn
     println("add bus")
    println()
    print("Enter busID")
    bus.BusID = Integer.valueOf(readLine())
    print("Enter bus route")
    bus.Route = Integer.valueOf(readLine())
    print("Enter bus origin")
    bus.Origin = readLine()!!
    print("Enter bus destination")
    bus.Destination = readLine()!!
    print("Enter bus time of departure")
    bus.Departuretime = Integer.valueOf(readLine())
    print("Enter bus time of arrival")
    bus.arrivaltime = Integer.valueOf(readLine())

    if(bus.Route !=null && bus.Origin.isNotEmpty() && bus.Destination.isNotEmpty() && bus.Departuretime != null && bus.arrivaltime != null){
        val ps = conn.prepareStatement("INSERT INTO `businfo`(`BusID`, `Route`, `Origin`, `Destination`, `Departuretime`, `arrivaltime`) " +
                "values (${bus.BusID},${bus.Route},'${bus.Origin}','${bus.Destination}',${bus.Departuretime},${bus.arrivaltime})")
        ps.executeUpdate()
        ps.close()
        conn.close()

    }
}

fun deleteBus(){

}

fun searchBusByRoute(){
    println("Searching bus by route Number")
    println()
    
}
