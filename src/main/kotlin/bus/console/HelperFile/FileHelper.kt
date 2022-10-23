package bus.console.HelperFile
import bus.console.Database.Database
//import bus.console.main.bus
import bus.console.models.BusModel
import mu.KotlinLogging
import java.io.*

val logger = KotlinLogging.logger {}

//writing to the database
fun write( bus:BusModel) {

  //  val file = File(fileName)
    try {
        val conn = Database().conn
      //  val outputStreamWriter = OutputStreamWriter(FileOutputStream(file))
      //  outputStreamWriter.write(data)
        val ps = conn.prepareStatement(
            "INSERT INTO `businfo`(`BusID`, `Route`, `Origin`, `Destination`, `Departuretime`, `arrivaltime`) " +
                    "values (${bus.BusID},${bus.Route},'${bus.Origin}','${bus.Destination}',${bus.Departuretime},${bus.arrivaltime})"
        )
        ps.executeUpdate()
        ps.close()
        conn.close()
      //  outputStreamWriter.close()
    } catch (e: Exception) {
        logger.error { "Cannot read file: " + e.toString() }
    }
}

//reading from the database
fun read(): ArrayList<BusModel> {
    try {
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
    } catch (e: FileNotFoundException) {
        logger.error { "Cannot Find file: " + e.toString() }
    } catch (e: IOException) {
        logger.error { "Cannot Read file: " + e.toString() }
    }
    return ArrayList()
}
//deleting from the database
fun deleteBus(bus: BusModel){
    try{
        val conn = Database().conn
        val ps = conn.prepareStatement("delete from businfo where BusID = ?")
        ps.setInt(1, bus.BusID)
        ps.executeUpdate()
        ps.close()
        conn.close()
    }catch (e: IOException){

    }
}
//updating the database
fun updateBus(bus: BusModel): Boolean {
    try {
        val conn = Database().conn
        val stSQL = "UPDATE `businfo` " +
                "SET `Route`='${bus.Route}',`Origin`='${bus.Origin}',`Destination`='${bus.Destination}'," +
                "`Departuretime`='${bus.Departuretime}', `arrivaltime`='${bus.arrivaltime}' WHERE `BusID`= '${bus.BusID}'"
        val ps = conn.prepareStatement(stSQL)
        ps.executeUpdate()
        ps.close()
        conn.close()
    }catch (e: IOException){

    };return true
}

fun exists(fileName: String): Boolean {
    val file = File(fileName)
    return file.exists()
}
