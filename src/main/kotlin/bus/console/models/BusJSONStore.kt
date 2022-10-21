/*package bus.console.models

import bus.console.HelperFile.exists
import bus.console.HelperFile.logger
import bus.console.HelperFile.read
import bus.console.HelperFile.write
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.nio.file.Files.exists
import java.util.*

val JSON_FILE = "Buses.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<ArrayList<BusModel>>() {}.type
fun generateRandomId(): Int {
    return Random().nextInt()
}
class BusJSONStore: BusStore {
    var buses = mutableListOf<BusModel>()

    init {
        if (exists(JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<BusModel> {
        return buses
    }

    override fun findOne(id: Int) : BusModel? {
        var foundBus: BusModel? = buses.find { b -> b.BusID == id }
        return foundBus
    }

    override fun create(bus: BusModel) {
        bus.BusID = generateRandomId()
        buses.add(bus)
        serialize(bus)
    }
    override fun delete(bus: BusModel) {
        buses.remove(bus)
     //   serialize()
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
      //  serialize()
    }

    internal fun logAll() {
        buses.forEach { logger.info("${it}") }
    }

    private fun serialize(bus:BusModel) {
       // val jsonString = gsonBuilder.toJson(buses, listType)
        write(bus)
    }

    private fun deserialize() {
       // val jsonString = read(JSON_FILE)
       // buses = read(BusModel)
    }
}

 */