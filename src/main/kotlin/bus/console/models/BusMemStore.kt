package bus.console.models

import bus.console.HelperFile.deleteBus
import bus.console.HelperFile.read
import bus.console.HelperFile.write
import java.util.*
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
    override fun delete(bus: BusModel) {
        buses.remove(bus)
        deleteBus(bus)
    }
    override fun update(bus: BusModel) {
        var foundBus = findOne(bus.BusID!!)
        if (foundBus != null) {
            foundBus.Route = bus.Route
            foundBus.Origin = bus.Origin
            foundBus.Destination = bus.Destination
            foundBus.Departuretime = bus.Departuretime
            foundBus.arrivaltime = bus.arrivaltime
        }
    }

    override fun load(){
        buses = read()
    }

    internal fun logAll() {
        buses.forEach {
            logger.info("${it}")
        }
    }
    }