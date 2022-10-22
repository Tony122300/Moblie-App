package bus.console.Database
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class Database {
    var conn: Connection

    init {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus-app", "root", "")
    }
    /*  fun connection() {
            try {
                val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bus-app", "root", "")
                println("ok")
            } catch (e: SQLException) {
                e.printStackTrace()
            }
        }
    }
       */
}