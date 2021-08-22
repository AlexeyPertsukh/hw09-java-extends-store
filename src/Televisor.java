//Телевизор
public class Televisor extends Product {

    private double screenDiagonal;      //диагональ, ''
    private String screenResolution;    //разрешение экрана, напр. "1920х1080"
    private String os;                  //операционная система


    public Televisor() {
        this("noname", "noname", 0, 0, "0x0", "none");
    }

    public Televisor(String brand, String model, double price, double screenDiagonal, String screenResolution, String os ) {
        super(brand, model, price);
        this.screenDiagonal = screenDiagonal;
        this.screenResolution = screenResolution;
        this.os = os;
    }

    public void loadFrom(Televisor televisor) {
        setBrand(televisor.getBrand());
        setModel(televisor.getModel());
        setPrice(televisor.getPrice());

        screenDiagonal = televisor.screenDiagonal;
        screenResolution = televisor.screenResolution;
        os = televisor.os;
    }


    @Override
    public void info() {
        super.info();
        String str;

        str = String.format("%6.0f", screenDiagonal);
        System.out.printf("Экран....................         %s\"  \n", str);
        str = String.format("%10s px", screenResolution);
        System.out.printf("Разрешение...............   %12s        \n", str);
        str = String.format("%12s", os);
        System.out.printf("ОС.......................%16s           \n", str);
    }

    @Override
    public void smallInfo() {
        super.info();
    }

    @Override
    public String getProductCategory() {
        return "ТЕЛЕВИЗОР";
    }


}
