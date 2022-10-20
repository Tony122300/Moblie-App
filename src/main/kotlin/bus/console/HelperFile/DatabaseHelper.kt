package bus.console.HelperFile

import bus.console.Database.Database
import bus.console.main.bus
import bus.console.models.BusModel

class DatabaseHelper {
    // just storing it here
    fun addBus(Bus: BusModel){
        val conn = Database().conn
        if(bus.Route !=null && bus.Origin.isNotEmpty() && bus.Destination.isNotEmpty() && bus.Departuretime != null && bus.arrivaltime != null) {
            val ps = conn.prepareStatement(
                "INSERT INTO `businfo`(`BusID`, `Route`, `Origin`, `Destination`, `Departuretime`, `arrivaltime`) " +
                        "values (${bus.BusID},${bus.Route},'${bus.Origin}','${bus.Destination}',${bus.Departuretime},${bus.arrivaltime})"
            )
            ps.executeUpdate()
            ps.close()
            conn.close()
        }
    }
}