package service

import model.Car

class CarRentalService {
    private val cars = mutableListOf(
        Car("1", "Toyota", "Corolla"),
        Car("2", "Honda", "Civic"),
        Car("3", "Ford", "Focus")
    )

    fun listCars(): List<Car> = cars

    fun rentCar(id: String): Car? {
        val car = cars.find { it.id == id && it.isAvailable }
        car?.rent()
        return car
    }

    fun returnCar(id: String): Car? {
        val car = cars.find { it.id == id && !it.isAvailable }
        car?.returnCar()
        return car
    }
}
