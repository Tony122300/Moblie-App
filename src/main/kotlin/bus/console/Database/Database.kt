package bus.console.Database
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

    object Test {
        fun connection() {
            try {
                val conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_create_db", "root", "")
                println("ok")
            } catch (e: SQLException) {
                e.printStackTrace()
            }
        }
    }