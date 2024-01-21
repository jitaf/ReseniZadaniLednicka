package autosaloon;

import java.util.Comparator;
import java.util.Scanner;

public class CarDatabase {

    String owner;
    Car[] cars;

    public CarDatabase(String owner) {
        this.owner = owner;
    }

    /**
     * Metoda se zepta uzivatele na informace k pozadovanemu poctu aut. A ty prida do pole aut.
     * @param count - pozadovany pocet aut
     */
    public void addCars(int count) {
        Scanner scanner = new Scanner(System.in);

        cars = new Car[count];

        for (int i=0; i<count; i++){
            System.out.println("Zadej detailz o aute #" + (i + 1));

            System.out.print("Rok vyroby: ");
            int yearOfManufacture = scanner.nextInt();

            System.out.print("Ujete kilometry: ");
            int mileage = scanner.nextInt();
            scanner.nextLine(); // Přečti zbývající nový řádek počtu ujetých kilometrů

            System.out.print("Barva: ");
            String color = scanner.nextLine();

            System.out.print("Zadej stav (BAD, GOOD, EXCELLENT, DAMAGED): ");

            /* nebo lze uživateli vypsat moznosti volby pomoci:
            for (Condition c : Condition.values()){
                System.out.print(c + " ");
            }*/

            String conditionString = scanner.nextLine().toLowerCase();

            Condition condition = Condition.valueOf(conditionString);

            cars[i] = new Car(yearOfManufacture, mileage, color, condition);
        }

    }

    /**
     * Vypise vsechna auta, jejijz stav je "good". Vypis bude ve formatu: Na prvnim radku bude vypis: Dobra auta jsou: .
     * Na kazdem dalsim radku bude vypis informaci o jednom aute - pouzij mezodu printInfo() tridy Car
     */
    public void printCarInGoodCondition(){
        System.out.println("Dobra auta jsou:");
        for (Car car : cars) {
            if (car.getCondition() == Condition.good) {
                System.out.println(car.getColor() + " - " + car.getKms());
            }
        }
    }

    // Metoda pro výpis auta s nejvíce najetými kilometry
    public void printCarWithMostKms() {
        System.out.println("Auto s nejvic kilometry:");
        Car carWithMostKms = null;
        int maxKms = 0;
        for (Car car : cars) {
            if (car.getKms() > maxKms) {
                maxKms = car.getKms();
                carWithMostKms = car;
            }
        }
        if (carWithMostKms != null) {
            System.out.print("Barva: " + carWithMostKms.getColor());
            System.out.println(" - Kilometry: " + carWithMostKms.getKms() + " km");
        } else {
            System.out.println("V databazi nejsou zadna auta.");
        }
    }

    // Metoda pro výpis zajímavostí
    public void printInterestingFacts() {
        System.out.println("Zajimave fakty:");
        System.out.println("Pocet aut: " + cars.length);
        System.out.println("Jmeno vlastnika: " + owner);
        System.out.println("Delka jmena vlastnika: " + owner.length());
        System.out.println("Prvni pismenka jmena vlastnika: " + owner.charAt(0));

        boolean hasDamagedCars = false;
        for (Car car: cars){
            if (car.getCondition() == Condition.damaged){
                hasDamagedCars = true;
            }
        }

        if (hasDamagedCars) {
            System.out.println("Nektere z aut je nabourane");
        } else {
            System.out.println("Vsechna auta jsou v poradku.");
        }

    }


}
