package bus.console.models

import bus.console.HelperFile.deleteBus
import bus.console.HelperFile.read
import bus.console.HelperFile.updateBus
import bus.console.HelperFile.write
import bus.console.main.bus
import bus.console.main.busView
import mu.KotlinLogging
import kotlin.collections.ArrayList

private val logger = KotlinLogging.logger {}


class BusMemStore : BusStore {
    var buses = ArrayList<BusModel>()


    override fun findAll(): List<BusModel> {
        return buses
    }

    override fun findOne(BusID: Int): BusModel? {
        var foundBus: BusModel? = buses.find {b -> b.BusID == BusID}
        return foundBus
    }

    override fun create(bus: BusModel) {
        buses.add(bus)
        write(bus)
        logAll()
    }
    //deletes bus also calling delete bus from filehelper
    override fun delete(bus: BusModel) {
        buses.remove(bus)
        deleteBus(bus)
    }

    //updating the bus if the busID is found also calling the update in file helper
    override fun update(bus: BusModel?) {
        val foundBus = findOne(bus?.BusID!!)
        if (foundBus != null) {
            foundBus.Route = bus.Route
            foundBus.Origin = bus.Origin
            foundBus.Destination = bus.Destination
            foundBus.Departuretime = bus.Departuretime
            foundBus.arrivaltime = bus.arrivaltime
            updateBus(foundBus)
        }
    }

    //to load the data from the database when the console starts
    override fun load(){
        buses = read()
    }


    internal fun logAll() {
        buses.forEach {
            logger.info("${it}")
        }
    }

    internal fun sort(){
        val routes = mutableListOf<BusModel>()
        buses.forEach{
            routes.add(it)
        }
        routes.sortWith(compareBy{it.Route})
        routes.forEach{
            println(buses)
        }
    }

    internal fun showallOriginToDestination(){
        val origin = mutableListOf<BusModel>()
        buses.forEach { origin.add(it)
        println("origin : " + it.Origin + ", Destination : " + it.Destination + ", Route" + it.Route)
        }
        origin.sortWith(compareBy{it.BusID})

    }
    }