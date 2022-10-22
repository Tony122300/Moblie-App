package bus.console.Controller

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
                0 -> addBus() //secret menu
                1 -> println("find bus by route")
                2 -> println("find bus by origin and destination")
                3 -> updateBus()
                4 -> println(searchBusByRoute())
                5 -> listBuses()
                6 -> println("list timetable based on Route")
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

    fun addBus(){
        var aBus = BusModel()
        if(busView.addBusData(aBus))
            buses.create(aBus)
    }
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
    fun listBuses(){
        busView.theBusesList()
    }



    fun deleteBus(){
        val theBusID = busView.deleteBus()
        val theBus = buses.findOne(theBusID)
        if (theBus != null) {
            buses.delete(theBus)
        }
    }

    fun updateBus(){
        val busWithUpdates = busView.updateBus()
        if(bus != null)
            buses.update(busWithUpdates)
    }
}