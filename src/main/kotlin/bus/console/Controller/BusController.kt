package bus.console.Controller

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
    //searching
    fun searchBusByRoute(){
    }
}