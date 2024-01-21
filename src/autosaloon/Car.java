package autosaloon;

public class Car {
    private int yearOfManufacture;
    private int kms;
    private String color;
    private Condition condition;

    // Parametrický konstruktor
    public Car(int yearOfManufacture, int mileage, String color, Condition condition) {
        this.yearOfManufacture = yearOfManufacture;
        this.kms = mileage;
        this.color = color;
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Metoda pro výpis informací o autě
    public void printInfo() {
        System.out.println("Car Information:");
        System.out.println("Year of Manufacture: " + yearOfManufacture);
        System.out.println("Mileage: " + kms  + " km");
        System.out.println("Color: " + color);
        System.out.println("Condition: " + condition);
    }
	
}
