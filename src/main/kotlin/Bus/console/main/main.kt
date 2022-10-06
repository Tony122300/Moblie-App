package Bus.console.main

fun main(args: Array<String>) {
    println("Placemark Kotlin App Version 1.0")

    var input: Int

    do {
        input = menu()
        when(input) {
            1 -> println("find bus by route")
            2 -> println("find bus by origin and destination")
            3 -> println("Buy ticket")
            4 -> println("search all routes")
            5 -> println("list all routes")
            6 -> println("find timetable")
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
    println("Shutting Down bus app Console App" )
}

fun menu() : Int {

    var option : Int
    var input: String? = null

    println("Main Menu")
    println(" 1. find bus by route")
    println(" 2. find bus by origin and destination")
    println(" 3. Buy ticket")
    println(" 4. search all routes")
    println(" 5. list all routes")
    println(" 6. find timetable")
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

fun listBusRoutes(){
    println("list all bus routes")
    println()

}