package elektroshop;

import java.util.Scanner;

public class Items {
    private Fridge[] items;
    Scanner scanner = new Scanner(System.in);

    /**
     * Metoda se zepta uzivatele na informace k pozadovanemu poctu ledniček. A ty prida do pole items.
     * @param count - pozadovany pocet lednicek
     */
    public void addItems(int count) {
        items = new Fridge[count];
        for (int i=0; i<count; i++){
            //nacti od uzivatele míru spotreby a rok výroby ledničky

            System.out.println("Enter the brand of the fridge:");
            String brand = scanner.nextLine();

            System.out.println("Enter the model of the fridge:");
            String model = scanner.nextLine();

            System.out.println("Enter the energy efficiency (A-G) of the fridge:");
            String efficiencyChar = scanner.nextLine();
            EnergyEfficiency efficiency = EnergyEfficiency.valueOf(efficiencyChar.toUpperCase());

            System.out.println("Enter the year of manufacture of the fridge:");
            int year = scanner.nextInt();
            scanner.nextLine();

            Fridge fridge = new Fridge(brand, model, efficiency, year);
            //pridej lednicku do pole lednicek
            items[i] = fridge;
        }

    }


    /**
     * Tato metoda vypise informace o lednickach. Na prvnim rádku bude text "-----INFO O LEDNICKACH----- ",
     * na dalsich radkach bude vzdy rok vyroby lednick, dvojtecka a popis spotreby. (Vyuzijte metodu printInfo() tridy Fridge.)
     * Na poslednim radku bude text "-----".
     */
    public void printInfo(){
        System.out.println("-----INFO O LEDNICKACH-----");
        for (Fridge item : items) {
            item.printInfo();
        }
        System.out.println("-----");
    }

    public void printItemsWithEnergyEfficiencyA() {
        for (Fridge item : items) {
            if (item.getEnergyEfficiency() == EnergyEfficiency.A) {
                item.printInfo();
            }
        }
    }

    public void printTotalItems() {
        System.out.println("Total number of items: " + items.length);
    }

    public void printEnergyEfficiencyStats() {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countE = 0;
        int countF = 0;

        for (Fridge item : items) {
            switch (item.getEnergyEfficiency()){
                case A:
                    countA++;
                    break;
                case B:
                    countB++;
                    break;
                case C:
                    countC++;
                    break;
                case D:
                    countD++;
                    break;
                case E:
                    countE++;
                    break;
                case F:
                    countF++;
                    break;
            }

        }
        System.out.println("Mame " + countA + " lednicek typu A.");
        System.out.println("Mame " + countB + " lednicek typu B.");
        System.out.println("Mame " + countC + " lednicek typu C.");
        System.out.println("Mame " + countD + " lednicek typu D.");
        System.out.println("Mame " + countE + " lednicek typu E.");
        System.out.println("Mame " + countF + " lednicek typu F.");

    }

}
