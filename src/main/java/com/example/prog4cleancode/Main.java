package com.example.prog4cleancode;

import com.example.prog4cleancode.service.CarRentalService;
import com.example.prog4cleancode.view.ConsoleInterface;

public class Main {
    public static void main(String[] args) {
        CarRentalService service = new CarRentalService();
        ConsoleInterface console = new ConsoleInterface(service);
        console.start();
    }
}
