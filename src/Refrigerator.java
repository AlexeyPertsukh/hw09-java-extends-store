//Холодильник
public class Refrigerator extends Product {

    private double  volume;         //объем, л.
    private String  energyClass;    //класс энергопотребления, напр. "A++"
    private double  powerUsageYear; //годовое энергопотребление, кВт*год

    public Refrigerator() {
        this("noname", "noname", 0, 0, "unknown", 0);
    }

    public Refrigerator(String brand, String model, double price, double volume, String energyClass, double powerUsageYear) {
        super(brand, model, price);
        this.volume = volume;
        this.energyClass = energyClass;
        this.powerUsageYear = powerUsageYear;
    }

    public void loadFrom(Refrigerator refrigerator) {
        setBrand(refrigerator.getBrand());
        setModel(refrigerator.getModel());
        setPrice(refrigerator.getPrice());

        volume = refrigerator.volume;
        energyClass = refrigerator.energyClass;
        powerUsageYear = refrigerator.powerUsageYear;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        String str = String.format("%.0f л", volume);
        System.out.printf("Объем.....................        %6s   \n", str);
        System.out.printf("Класс энергопотребления...        %6s     \n", energyClass);
        System.out.printf("Годовое энергопотребление.%6.0f кВт*год    \n", powerUsageYear);
    }

    @Override
    public void printSmallInfo() {
        System.out.println(super.getStrInfo());
    }

    @Override
    public String getProductCategory() {
        return "ХОЛОДИЛЬНИК";
    }

}
