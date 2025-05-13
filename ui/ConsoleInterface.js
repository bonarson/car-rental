import promptSync from 'prompt-sync';
import CarRentalService from '../services/CarRentalService.js';

export default class ConsoleInterface {
    constructor() {
        this.service = new CarRentalService();
        this.prompt = promptSync();
    }

    start() {
        console.log('Bienvenue dans l\'application de location de voiture');
        this.showMenu();
    }

    showMenu() {
        console.log('\n--- MENU LOCATION VOITURE ---');
        console.log('1. Voir les voitures disponibles');
        console.log('2. Louer une voiture');
        console.log('3. Retourner une voiture');
        console.log('0. Quitter');

        const choice = this.prompt('Votre choix : ').trim();
        switch (choice) {
            case '1':
                this.listCars();
                break;
            case '2':
                this.rentCar();
                break;
            case '3':
                this.returnCar();
                break;
            case '0':
                console.log('Merci pour votre visite !');
                process.exit(0);
            default:
                console.log('Choix invalide.');
                this.showMenu();
        }
    }

    listCars() {
        const cars = this.service.listCars();
        console.log('\nListe des voitures :');
        cars.forEach(car => console.log(car.toString()));
        this.showMenu();
    }

    rentCar() {
        const id = this.prompt("Entrez l'ID de la voiture à louer : ").trim();
        const car = this.service.rentCar(id);
        if (car) {
            console.log('Vous avez loué : ' + car.toString());
        } else {
            console.log('Voiture non disponible ou ID incorrect.');
        }
        this.showMenu();
    }

    returnCar() {
        const id = this.prompt("Entrez l'ID de la voiture à retourner : ").trim();
        const car = this.service.returnCar(id);
        if (car) {
            console.log('Merci pour le retour : ' + car.toString());
        } else {
            console.log('ID incorrect ou voiture déjà disponible.');
        }
        this.showMenu();
    }
}
