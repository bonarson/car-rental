export default class Car {
    constructor(id, brand, model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.isAvailable = true;
    }

    rent() {
        this.isAvailable = false;
    }

    returnCar() {
        this.isAvailable = true;
    }

    toString() {
        return `[${this.id}] ${this.brand} ${this.model} - ${this.isAvailable ? 'Disponible' : 'Louée'}`;
    }
}
