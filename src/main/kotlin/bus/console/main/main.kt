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

    /*
fun menu() : Int {

    var option : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. find bus by route ")
    println(" 2. find bus by origin and destination ")
    println(" 3. Buy ticket ")
    println(" 4. search bus by routes ")
    println(" 5. list all routes ")
    println(" 6. list timetable based on Route ")
    println(" 7. Delete Bus ")
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



 */
    /*
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

 */

    /*
fun addBus(BusID: Int, Route: Int, Origin: String, Destination:String, Departuretime: Int, arrivaltime: Int){
    val busObject = BusModel(BusID, Route,Origin,Destination, Departuretime, arrivaltime)
    buses.add(busObject)
}
*/
    /*
    fun addBus() {
        /* // val conn = Database().conn
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
/*
    if(bus.Route !=null && bus.Origin.isNotEmpty() && bus.Destination.isNotEmpty() && bus.Departuretime != null && bus.arrivaltime != null){
        val ps = conn.prepareStatement("INSERT INTO `businfo`(`BusID`, `Route`, `Origin`, `Destination`, `Departuretime`, `arrivaltime`) " +
                "values (${bus.BusID},${bus.Route},'${bus.Origin}','${bus.Destination}',${bus.Departuretime},${bus.arrivaltime})")
        ps.executeUpdate()
        ps.close()
        conn.close()

   */

    }

     */

 */

    /*
fun deleteBus(bus: BusModel){
    val conn = Database().conn
    println("delete bus")
    println()
    print("Enter busID")
  val id = Integer.valueOf(readLine())
    val theBus = buses.findOne(id)
    if (theBus != null) {
        buses.delete(theBus)
    }
}

 */
/*
    fun searchBusByRoute(): List<BusModel> {
        val conn = Database().conn
        println("Search bus by Route")
        println()
        print("search by Route")
        bus.Route = Integer.valueOf(readLine()) //version1
        val ps = conn.prepareStatement("SELECT * FROM `businfo` WHERE Route = ?") //version1
        ps.setInt(1, bus.Route) //version1
        val resultSet = ps.executeQuery()
        val busModels = ArrayList<BusModel>()
        while (resultSet.next()) {
            val BusID = resultSet.getInt("busID")
            val Route = resultSet.getInt("Route")
            val Origin = resultSet.getString("Origin")
            val Destination = resultSet.getString("Destination")
            val Departuretime = resultSet.getDouble("Departuretime")
            val arrivaltime = resultSet.getDouble("arrivaltime")
            val bus = BusModel(BusID, Route, Origin, Destination, Departuretime, arrivaltime)
            busModels.add(bus)

            // val routeNum = Integer.valueOf(readLine())  //version2
            //     val ps = conn.prepareStatement("SELECT * FROM `businfo` WHERE Route = ${routeNum}")//version2
            //run the query and get the resultset##
            //loop through the resultset and print each route to the console
        }
        ps.close()
        conn.close()
        return busModels
    }

    /*
fun searchBusByRoute(): List<BusModel> {
    val conn = Database().conn
    println("Search bus by Route or Origin")
    println()
    print("search by Route")
    bus.Route = Integer.valueOf(readLine()) //version1
    val ps = conn.prepareStatement("SELECT * FROM `businfo` WHERE Route = ?") //version1
    ps.setInt(1, bus.Route) //version1
    val resultSet = ps.executeQuery()
    val busModels = ArrayList<BusModel>()
    while (resultSet.next()) {
        val BusID = resultSet.getInt("busID")
        val Route = resultSet.getInt("Route")
        val Origin = resultSet.getString("Origin")
        val Destination = resultSet.getString("Destination")
        val Departuretime = resultSet.getInt("Departuretime")
        val arrivaltime = resultSet.getInt("arrivaltime")
        val bus = BusModel(BusID, Route, Origin, Destination, Departuretime, arrivaltime)
        busModels.add(bus)

        // val routeNum = Integer.valueOf(readLine())  //version2
        //     val ps = conn.prepareStatement("SELECT * FROM `businfo` WHERE Route = ${routeNum}")//version2
        //run the query and get the resultset##
        //loop through the resultset and print each route to the console
    }
    ps.close()
    conn.close()
    return busModels
}

     */
     2
 */

}
