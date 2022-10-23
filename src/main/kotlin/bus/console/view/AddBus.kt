package bus.console.view

import bus.console.Database.Database
import bus.console.main.bus
import bus.console.main.buses
import bus.console.models.BusModel
import javafx.beans.property.SimpleDoubleProperty
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
private var DeparturetimeDouble = SimpleDoubleProperty()
private var arrivaltimeDouble =SimpleDoubleProperty()
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
                Departuretime = textfield(DeparturetimeDouble) {

                }
                field("Arrival time")
                arrivaltime = textfield(arrivaltimeDouble) {

                }
                    }
            button ("adding bus"){
                action{
                    val aBus = BusModel(
                        IDInt.value,
                        RouteInt.value,
                        OriginString.value,
                        DestinationString.value,
                        DeparturetimeDouble.value,
                        arrivaltimeDouble.value
                    )
                    if(IDInt.value.toString() != "0" && RouteInt.value.toString() != "0" && OriginString.value != "" && DestinationString.value != "" && DeparturetimeDouble.value.toString() != "0.0" && arrivaltimeDouble.value.toString() !="0.0"){
                    buses.create(aBus)
                }
                    }
                }

            }
        }
    }
