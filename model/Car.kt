package model

data class Car(
    val id: String,
    val brand: String,
    val model: String,
    var isAvailable: Boolean = true
) {
    fun rent() {
        isAvailable = false
    }

    fun returnCar() {
        isAvailable = true
    }

    override fun toString(): String {
        val status = if (isAvailable) "Disponible" else "Louée"
        return "[$id] $brand $model - $status"
    }
}
