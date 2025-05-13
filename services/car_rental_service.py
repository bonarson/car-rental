from models.car import Car

class CarRentalService:
    def __init__(self):
        self.cars = [
            Car("1", "Toyota", "Corolla"),
            Car("2", "Honda", "Civic"),
            Car("3", "Ford", "Focus")
        ]

    def list_cars(self):
        return self.cars

    def rent_car(self, car_id):
        for car in self.cars:
            if car.id == car_id and car.is_available:
                car.rent()
                return car
        return None

    def return_car(self, car_id):
        for car in self.cars:
            if car.id == car_id and not car.is_available:
                car.return_car()
                return car
        return None
