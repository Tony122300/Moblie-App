package bus.console.view

import bus.console.Database.Database
import bus.console.main.bus
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.TextField
import tornadofx.*
import javax.print.attribute.standard.Destination

private var ID: TextField by singleAssign()
private var Route: TextField by singleAssign()
private var Origin: TextField by singleAssign()
//private var Destination: String = ""

private var Destination: TextField by singleAssign()
private var Departuretime: TextField by singleAssign()
private var arrivaltime: TextField by singleAssign()

private var IDInt = SimpleIntegerProperty()
private var RouteInt = SimpleIntegerProperty()
private var OriginString = SimpleStringProperty()
private var DestinationString = SimpleStringProperty()
private var DeparturetimeINT = SimpleIntegerProperty()
private var arrivaltimeINT = SimpleIntegerProperty()
class AddBus : View("My View") {
    override val root = vbox(80) {
        label("add bus")
        form {
            setPrefSize(200.0,500.0)
            fieldset {
                field("Bus ID")
                ID = textfield (IDInt){

                }
                field("Route")
                Route = textfield(RouteInt){

                }
                field("Origin")
                Origin = textfield(OriginString) {

                }
                field("Destination")
                Destination = textfield(DestinationString) {

                }
                field("Departure Time")
                Departuretime = textfield(DeparturetimeINT) {

                }
                field("Arrival time")
                arrivaltime = textfield(arrivaltimeINT) {

                }
                    }
            button ("adding bus"){
                action{
                    println(Destination.text)
                    if(IDInt.value != null && RouteInt.value != null && OriginString.value.toString() != null && DestinationString.value.toString() != null && DeparturetimeINT.value != null && arrivaltimeINT.value != null){
                        bus.BusID= IDInt.value
                        bus.Route = RouteInt.value
                        bus.Origin = OriginString.value
                        bus.Destination = DestinationString.value
                        bus.Departuretime = DeparturetimeINT.value
                        bus.arrivaltime = arrivaltimeINT.value
                    }
                }

            }
        }
    }
}