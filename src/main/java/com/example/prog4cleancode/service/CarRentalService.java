package com.example.prog4cleancode.service;

import com.example.prog4cleancode.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarRentalService {
    private List<Car> cars;

    public CarRentalService() {
        cars = new ArrayList<>();
        cars.add(new Car("1", "Toyota", "Corolla", true));
        cars.add((new Car("2", "Honda", "Civic", false)));
        cars.add((new Car("3", "Ford", "Focus", true)));
    }

    public List<Car> listCars() {
        return cars;
    }

    public Optional<Car> rentCar(String id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id) && car.isAvailable())
                .findFirst()
                .map(car -> {
                    car.rent();
                    return car;
                });
    }

    public Optional<Car> returnCar(String id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id) && !car.isAvailable())
                .findFirst()
                .map(car -> {
                    car.returnCar();
                    return car;
                });
    }



}
