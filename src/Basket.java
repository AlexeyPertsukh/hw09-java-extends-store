//Корзина для заказов
public class Basket {
    private Product[]       products;

    public Basket() {
        products = new Product[0];
    }

    public  boolean add(Product prod) {
        //проверка на дубликаты
        for (Product tmp : products) {
            if (tmp == prod) {
                return false;
            }
        }

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++ ) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = prod;
        products = tmp;

        return true;
    }

    //удаляет товар из корзины, возвращает имя удаленного товара или ""
    public String del(int num) {
        if((num < 0) || (num >= products.length)) { //если недопустимый номер в массиве - выход
            return "";
        }

        String str = products[num].getProductCategory() + " " + products[num].getBrand() + " " + products[num].getModel() + ", " + products[num].getPrice() + " грн.";

        Product[] tmp = new Product[products.length - 1];

        for (int i = 0; i < tmp.length; i++) {
            if(i < num) {
                tmp[i] = products[i];
            }
            else {
                tmp[i] = products[i + 1];
            }
        }
        products = tmp;

        return str;
    }

    public void info() {
        if (products.length == 0) {
            System.out.println("Корзина пуста");
        }

        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. %s \n", i +1, products[i].getProductCategory() );
            products[i].info();
            System.out.println();
        }
    }

}
