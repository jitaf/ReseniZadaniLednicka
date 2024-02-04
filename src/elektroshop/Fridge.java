package elektroshop;

public class Fridge {
    private String brand;
    private String model;
    private EnergyEfficiency energyEfficiency;
    private int yearOfManufacture;


    public Fridge(String brand, String model, EnergyEfficiency energyEfficiency, int yearOfManufacture) {
        this.brand = brand;
        this.model = model;
        this.energyEfficiency = energyEfficiency;
        this.yearOfManufacture = yearOfManufacture;
    }

    public EnergyEfficiency getEnergyEfficiency() {
        return energyEfficiency;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void printInfo() {
        String text = "";
        //zapis switch v java 21
        switch (energyEfficiency){
            case A -> text="very low";
            case B -> text = "low";
            case C -> text="normal";
            case D -> text = "above normal";
            case E -> text="very high";
            case F -> text = "extremely high";
            default -> text= "n/a";
        }

        //starsi zapis
        /*switch (energyEfficiency){
            case A:
                text="very low";
                break;
            case B:
                text = "low";
                break;
            case C:
                text="normal";
                break;
            case D:
                text = "above normal";
                break;
            case E:
                text="very high";
                break;
            case F:
                text = "extremely high";
                break;
            default:
                text= "n/a";
        }*/
        System.out.println(yearOfManufacture + ": " + text);
    }
}
