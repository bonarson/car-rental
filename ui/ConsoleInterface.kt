package ui

import service.CarRentalService

class ConsoleInterface {
    private val service = CarRentalService()

    fun start() {
        println("Bienvenue dans l'application de location de voitures")
        while (true) {
            showMenu()
        }
    }

    private fun showMenu() {
        println("\n--- MENU ---")
        println("1. Voir les voitures")
        println("2. Louer une voiture")
        println("3. Retourner une voiture")
        println("0. Quitter")
        print("Choix : ")

        when (readLine()?.trim()) {
            "1" -> listCars()
            "2" -> rentCar()
            "3" -> returnCar()
            "0" -> {
                println("Merci pour votre visite !")
                kotlin.system.exitProcess(0)
            }
            else -> println("Choix invalide.")
        }
    }

    private fun listCars() {
        println("\nListe des voitures :")
        service.listCars().forEach { println(it) }
    }

    private fun rentCar() {
        print("ID de la voiture à louer : ")
        val id = readLine()?.trim()
        val car = id?.let { service.rentCar(it) }

        if (car != null) {
            println("Vous avez loué : $car")
        } else {
            println("Voiture non disponible ou ID incorrect.")
        }
    }

    private fun returnCar() {
        print("ID de la voiture à retourner : ")
        val id = readLine()?.trim()
        val car = id?.let { service.returnCar(it) }

        if (car != null) {
            println("Merci pour le retour : $car")
        } else {
            println("ID incorrect ou voiture déjà disponible.")
        }
    }
}
