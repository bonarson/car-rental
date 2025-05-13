class Car:
    def __init__(self, car_id, brand, model):
        self.id = car_id
        self.brand = brand
        self.model = model
        self.is_available = True

    def rent(self):
        self.is_available = False

    def return_car(self):
        self.is_available = True

    def __str__(self):
        status = "Disponible" if self.is_available else "Louée"
        return f"[{self.id}] {self.brand} {self.model} - {status}"
