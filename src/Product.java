//Базовый класс для телевизора, холодильника и стиралки
public class Product {
    private String brand;
    private String model;
    private double price;

    public Product() {
        this("noname", "noname", 0);
    }

    public Product(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String getStrInfo() {
        String str = String.format("%s %s", brand, model);
        str = String.format("%-27s", str);
        str = String.format("%s %8.1f грн", str, price);

        return str;
    }

    public void info(){
        System.out.println(getStrInfo());
    }

    public void smallInfo() {

    }

    //потомки будут возвращать название категории товара
    public String getProductCategory() {
        return "Fundamental";
    }



}
