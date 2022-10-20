package bus.console.models

interface BusStore {
    fun findAll(): List<BusModel>
    fun findOne(id: Int): BusModel?
    fun delete(bus: BusModel)
    fun create(bus: BusModel)
    fun update(bus: BusModel)
}