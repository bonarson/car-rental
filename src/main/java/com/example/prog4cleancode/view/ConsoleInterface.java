package com.example.prog4cleancode.view;

import com.example.prog4cleancode.model.Car;
import com.example.prog4cleancode.service.CarRentalService;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    private final CarRentalService rentalService;
    private final Scanner scanner;


    public ConsoleInterface(CarRentalService service) {
        this.rentalService = service;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("\n--- MENU LOCATION VOITURE ---");
        System.out.println("1. Voir les voitures disponibles");
        System.out.println("2. Louer une voiture");
        System.out.println("3. Retourner une voiture");
        System.out.println("0. Quiter");
        System.out.println("Votre choix : ");
    }

    private void listCars() {
        List<Car> cars = rentalService.listCars();
        System.out.println("\nListe des voitures : ");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private void rentCar() {
        System.out.println("Entrez l'ID de la voiture a louer : ");
        String id = scanner.nextLine();
        rentalService.rentCar(id).ifPresentOrElse(
                car -> System.out.println("Vous avez loue : " + car),
                () -> System.out.println("Voiture non disponible ou ID incorreact")
        );
    }

    private void returnCar() {
        System.out.println("Entrez l'ID de la voiture à retourner : ");
        String id = scanner.nextLine();
        rentalService.returnCar(id).ifPresentOrElse(
                car -> System.out.println("Merci pour le retour : " + car),
                () -> System.out.println("ID incorrect ou voiture déja disponible.")
        );
    }

    public void start() {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> listCars();
                case 2 -> rentCar();
                case 3 -> returnCar();
                case 0 -> System.out.println("Merci d'avoir utilisé notre service !");
                default -> System.out.println("Choix invalide.");
            }
        } while (choice != 0);
    }


}
