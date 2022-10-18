package bus.console.models

data class BusModel(var BusID: Int=123, var Route: Int=22, var Origin: String="", var Destination: String="", var Departuretime: Int =0, var arrivaltime: Int =0)