package bus.console.models

data class BusModel(var BusID: Int =0, var Route: Int=0, var Origin: String="", var Destination: String="", var Departuretime: Double =0.0, var arrivaltime: Double =0.0)