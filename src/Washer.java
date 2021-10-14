//Стиральная машина
public class Washer extends Product {
    public double weightLaundry;     // макс. вес белья для стики, кг.
    public double powerUsage;        //энергопотребление кВт*ч
    public double waterUsage;        // потребление воды за одну стирку, л.

    public Washer(String brand, String model, double price, double weightLaundry, double powerUsage, double waterUsage) {
        super(brand, model, price);
        this.weightLaundry = weightLaundry;
        this.powerUsage = powerUsage;
        this.waterUsage = waterUsage;

    }

    public void loadFrom(Washer washer) {
        setBrand(washer.getBrand());
        setModel(washer.getModel());
        setPrice(washer.getPrice());

        weightLaundry = washer.weightLaundry;
        powerUsage = washer.powerUsage;
        waterUsage = washer.waterUsage;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        String str = String.format("%6.1f кг", weightLaundry);
        System.out.printf("Максимальный вес белья...   %12s      \n", str);
        str = String.format("%6.2f кВт*ч", powerUsage);
        System.out.printf("Электропотребление.......   %12s      \n", str);
        str = String.format("%6.1f л", waterUsage);
        System.out.printf("Потребление воды.........   %12s      \n", str);
    }

    @Override
    public void printSmallInfo() {
        System.out.println(super.getStrInfo());
    }

    @Override
    public String getProductCategory() {
        return "СТИРАЛЬНАЯ МАШИНА";
    }
}
