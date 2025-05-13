from services.car_rental_service import CarRentalService

class ConsoleInterface:
    def __init__(self):
        self.service = CarRentalService()

    def start(self):
        print("Bienvenue dans l'application de location de voitures")
        while True:
            self.show_menu()

    def show_menu(self):
        print("\n--- MENU LOCATION VOITURE ---")
        print("1. Voir les voitures disponibles")
        print("2. Louer une voiture")
        print("3. Retourner une voiture")
        print("0. Quitter")

        choice = input("Votre choix : ").strip()

        if choice == "1":
            self.list_cars()
        elif choice == "2":
            self.rent_car()
        elif choice == "3":
            self.return_car()
        elif choice == "0":
            print("Merci pour votre visite !")
            exit()
        else:
            print("Choix invalide.")

    def list_cars(self):
        print("\nListe des voitures :")
        for car in self.service.list_cars():
            print(car)

    def rent_car(self):
        car_id = input("Entrez l'ID de la voiture à louer : ").strip()
        car = self.service.rent_car(car_id)
        if car:
            print("Vous avez loué :", car)
        else:
            print("Voiture non disponible ou ID incorrect.")

    def return_car(self):
        car_id = input("Entrez l'ID de la voiture à retourner : ").strip()
        car = self.service.return_car(car_id)
        if car:
            print("Merci pour le retour :", car)
        else:
            print("ID incorrect ou voiture déjà disponible.")
