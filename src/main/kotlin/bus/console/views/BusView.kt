package bus.console.views

import bus.console.HelperFile.read
import bus.console.main.buses
import bus.console.models.BusModel
//import bus.console.models.BusJSONStore
import bus.console.models.BusMemStore
class BusView {
    fun menu() : Int {

        var option : Int
        var input: String?

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

    // adding a bus entering the details
fun addBusData(bus : BusModel) : Boolean {
    println("add bus")
    println()
    print("Enter BusID")
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
    return bus.BusID !=null && bus.Route !=null && bus.Origin.isNotEmpty() && bus.Destination.isNotEmpty() && bus.Departuretime != null && bus.arrivaltime != null
}

    // listing the bus
    fun theBusesList(buses : BusMemStore){
        //  return buses.findAll()
        println("List All buses")
        println()
        buses.logAll()
        println()
    }
// deleting bus by busID
    fun deleteBus(): Int{
        println("delete bus")
        println()
        print("Enter busID")
        val busID = Integer.valueOf(readLine())
        return busID
    }
//searching bus by route
    fun search(): Int{
        println("Search bus by Route")
        println()
        print("search by Route")
        val route = Integer.valueOf(readLine())
        return route

    }
//updating bus if the new values entered is not empty replace with old values
    fun updateBus(): BusModel? {
        val newRoute: Int?
        val newOrigin: String?
        val newDestination: String?
        val newDeparturetime: Int?
        val newarrivaltime: Int?
        val bus=BusModel()
        println("Enter the BusID you want to update")
        bus.BusID = Integer.valueOf(readLine())
        println()

        println("update bus")
        println()
        print("Enter route")
        newRoute = Integer.valueOf(readLine())
        print("Enter Origin")
        newOrigin = readLine()
        print("Enter Destination")
        newDestination = readLine()
        print("Enter Departuretime")
        newDeparturetime = Integer.valueOf(readLine())
        print("Enter arrivaltime")
        newarrivaltime = Integer.valueOf(readLine())

        if(newRoute != null && newOrigin != null && newDestination != null && newDeparturetime != null && newarrivaltime != null){
            bus.Route = newRoute
            bus.Origin = newOrigin
            bus.Destination = newDestination
            bus.Departuretime = newDeparturetime
            bus.arrivaltime = newarrivaltime
            return bus
        }
        return null


    }
}