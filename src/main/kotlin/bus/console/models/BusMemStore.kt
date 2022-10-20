package bus.console.models

import java.util.*
import mu.KotlinLogging
import kotlin.collections.ArrayList

private val logger = KotlinLogging.logger {}
var lastId = 0

internal fun getId(): Int {
    return lastId++
}

class BusMemStore : BusStore {
    val buses = ArrayList<BusModel>()

    override fun findAll(): List<BusModel> {
        return buses
    }

    override fun findOne(id: Int): BusModel? {
        var foundBus: BusModel? = buses.find {b -> b.BusID == id}
        return foundBus
    }

    override fun create(bus: BusModel) {
        bus.BusID = getId()
        buses.add(bus)
        logAll()
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


    internal fun logAll() {
        buses.forEach { logger.info("${it}") }
    }
    }