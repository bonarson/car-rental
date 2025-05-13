import Car from '../models/Car.js';

export default class CarRentalService {
    constructor() {
        this.cars = [
            new Car('1', 'Toyota', 'Corolla'),
            new Car('2', 'Honda', 'Civic'),
            new Car('3', 'Ford', 'Focus')
        ];
    }

    listCars() {
        return this.cars;
    }

    rentCar(id) {
        const car = this.cars.find(c => c.id === id && c.isAvailable);
        if (car) {
            car.rent();
            return car;
        }
        return null;
    }

    returnCar(id) {
        const car = this.cars.find(c => c.id === id && !c.isAvailable);
        if (car) {
            car.returnCar();
            return car;
        }
        return null;
    }
}
