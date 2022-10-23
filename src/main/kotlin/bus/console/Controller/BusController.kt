package bus.console.Controller

import bus.console.Database.Database
import bus.console.HelperFile.read
import bus.console.main.*
import bus.console.models.BusMemStore
import bus.console.models.BusModel
import bus.console.views.BusView

class BusController {
    val buses = BusMemStore()
    val busView = BusView()
    fun start() {
        buses.load()

        var input: Int
        do{
            input = menu()
            when(input){
                0 -> addBus()
                1 -> listBuses()
                2 -> searchBusByRoute()
                3 -> updateBus()
                4 -> deleteBus()
                5 -> println("")
                6 -> println("list")
                7 -> deleteBus()
                -1 -> println("Exiting App")
                else -> println("Invalid Option")
            }
            println()
        }while(input != -1)
    }

    fun menu() :Int {
        return busView.menu()
    }
//adding to the bus
    fun addBus(){
        var aBus = BusModel()
        if(busView.addBusData(aBus))
            buses.create(aBus)
    }
// listing the bus
    fun listBuses(){
        busView.theBusesList(buses)
    }


// deleting the bus
    fun deleteBus(){
        val theBusID = busView.deleteBus()
        val theBus = buses.findOne(theBusID)
        if (theBus != null) {
            buses.delete(theBus)
        }
    }
// updating
    fun updateBus(){
        val busWithUpdates = busView.updateBus()
        if(bus != null)
            buses.update(busWithUpdates)
    }
    //searching from database had an error with searching from arraylist
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
}