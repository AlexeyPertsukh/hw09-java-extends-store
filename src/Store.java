import java.util.Scanner;

//Магазин
public class Store {

    private Televisor[] televisors;
    private Refrigerator[] refrigerators;
    private Washer[] washers;
    private Basket basket;
    private Product curProd;
    private boolean exit;
    private int activePage; //номер активной страницы магазина
    private int prevPage;
    private final Scanner sc;

    private final static int PAGE_MASTER = 0;
    private final static int PAGE_TELEVISOR = 1;
    private final static int PAGE_REFRIGERATOR = 2;
    private final static int PAGE_WASHER = 3;
    private final static int PAGE_BASKET = 4;
    private final static int PAGE_SPECIFICATION = 5;


    public Store() {
        sc = new Scanner(System.in);
    }

    //========================= ОСНОВНОЙ БЛОК ===========================
    public void go() {
        televisors    = new Televisor[0];
        refrigerators = new Refrigerator[0];
        washers       = new Washer[0];
        basket        = new Basket();

        addProducts();          //добавляем все товары в магазин
        loadPageMaster();       //открываем главную страницу

        //пока не введем команду на выход - крутимся
        int cmd;
        do{
            System.out.print("Введите команду: ");
            String strCmd = sc.next();

            if(Util.isInteger(strCmd)) {
                cmd = Integer.parseInt(strCmd);
                inputCmd(cmd);
            }
            else {
             Color.printlnColorYellow("Недопустимая команда");
            }


        } while(! exit);
        printOnEnd();
    }
    //===================================================================

    private void printOnEnd() {
        System.out.println();
        Color.printlnColorYellow("JAVA A01 \"ШАГ\", Запорожье 2021");    //by
        Color.printlnColorYellow("Перцух Алексей");
        Color.printlnColorYellow("https://github.com/AlexeyPertsukh/hw09-java-extends-store");
    }


    //Ввод команд
    private void inputCmd(int cmd) {

        //===команды на главной
        if (activePage == PAGE_MASTER) {
            switch (cmd) {
                case 0:
                    exit = true;
                    return;
                case 1:
                case 2:
                case 3:
                    loadPageCategory(cmd - 1);
                    return;
                case 4:
                    loadPageBasket();
                    return;
                default:
                    Color.printlnColorYellow("Неизвестная команда");
                    return;
            }
        }

        //===команды на страницах с категориями товаров
        if (activePage >= PAGE_TELEVISOR && activePage <= PAGE_WASHER) {

            if (cmd == 0) {
                loadPageMaster();
                return;
            }

            Product[][] products = {televisors, refrigerators, washers};
            int category;   //категория
            int num;        //номер товара
            category = activePage - 1;
            num = cmd - 1;  //номер товара
            //загрузка спецификации товара
            if((num >= 0) && (num < products[category].length)) {
                loadPageSpecification(products[category][num]);
            }
            else {
                Color.printlnColorYellow("Нет товара с номером " + cmd);
            }

            return;
        }

        //===Команды на страницы спецификации
        if(activePage == PAGE_SPECIFICATION) {

            switch (cmd) {
                case 0:
                    loadPrevPage();
                    return;
                case 1:
                    boolean status = basket.add(curProd);   //false если товар уже есть в корзине
                    if(status) {
                        String str = curProd.getBrand() + " " + curProd.getModel() + ", " + curProd.getPrice() + " грн.";
                        Color.printlnColorYellow("В корзину добавлен товар: " + str);
                    }
                    else {
                        Color.printlnColorYellow("Товар уже есть в корзине");
                    }
                    return;
                case 2:
                    loadPageBasket();
                    return;
                case 3:
                    loadPageMaster();
                    return;
                default:
                    Color.printlnColorYellow("Неизвестная команда");
                    return;
            }
        }

        //===Команды на странице корзины
        if (activePage == PAGE_BASKET) {
            int num;
            if (cmd == 0) {  //вернуться назад
                loadPageMaster();
                return;
            } else {  //удалить товар из корзины
                num = cmd - 1;

                String nameDelProduct = basket.del(num);       //при норм. удалении возвращает инфу удаленного товара
                if (nameDelProduct.compareToIgnoreCase("") != 0) {
                    loadPageBasket();
                    Color.printlnColorYellow("Из корзины удален товар: " + nameDelProduct);
                    return;
                } else {
                    Color.printlnColorYellow("В корзине нет товара с номером " + cmd);
                    return;
                }
            }
        }

        //Ввели неизвестную команду
        Color.printlnColorYellow("Неизвестная команда");
    }


    //заполнение магазина товарами
    private void addProducts() {
        addTelevisor("Kivi",  "40U600KD", 7_999, 40, "3840x2160", "Android 9.0");
        addTelevisor("LG",  "43UN71006LB", 12_499, 43, "3840x2160", "WebOS");
        addTelevisor("Gazer",  "TV32-HS2G", 6_999 , 32, "1366x768", "Android");
        addTelevisor("Sony",  "KD75XH9505BR2", 109_999 , 75, "3840x2160", "Android");

        addRefrigerator("BOSCH", "KGN36XI35", 13_599, 237, "A++", 260);
        addRefrigerator("Grunhelm", "GRW-185DD", 10_754, 84, "A+", 109);
        addRefrigerator("LIEBHERR", "CBNbe 5778", 68_999, 434, "A+++", 195);

        addWasher("SAMSUNG", "WF60F1R2E2WDUA", 8_499, 6, 0.86, 36);
        addWasher("ELECTROLUX", "EW6T4062U", 11_899, 6, 0.8, 55);
        addWasher("MILANO", "XPB-30 PA Rose", 1_959, 3.5, 0.32, 14);
        addWasher("INDESIT", "IWUC 40851 UA", 5_799, 4, 0.77, 17);
        addWasher("CANDY", "CS4 1262DE/1-S", 6_599, 6, 0.65, 40.5);
        addWasher("LG", "F2V9HS9T", 15_999, 7, 0.63, 28);
        addWasher( "INDESIT", "OMTWE 71483 W EU", 8_899, 7, 0.79, 49);
    }

    //Добавление телевизоров
    private void addTelevisor(String brand, String model, double price, double screenDiagonal, String screenResolution, String os) {
        Televisor[] tmp = new Televisor[televisors.length + 1];
        System.arraycopy(televisors, 0, tmp, 0, televisors.length);

        tmp[tmp.length - 1] = new Televisor(brand, model, price, screenDiagonal, screenResolution, os);
        televisors = tmp;
    }

    //Добавление холодильников
    private void addRefrigerator(String brand, String model, double price, double volume, String energyClass, double powerUsageYear) {
        Refrigerator[] tmp = new Refrigerator[refrigerators.length + 1];
        System.arraycopy(refrigerators, 0, tmp, 0, refrigerators.length);

        tmp[tmp.length - 1] = new Refrigerator(brand, model, price, volume, energyClass, powerUsageYear);
        refrigerators = tmp;
    }

    //Добавление стиралок
    private void addWasher(String brand, String model, double price, double weightLaundry, double powerUsage, double waterUsage) {
        Washer[] tmp = new Washer[washers.length + 1];
        System.arraycopy(washers, 0, tmp, 0, washers.length);

        tmp[tmp.length - 1] = new Washer(brand, model, price, weightLaundry, powerUsage, waterUsage);
        washers = tmp;
    }

    //верхняя панель
    private void printHeadline(String str) {
        Color.printlnColorBlue("==================================================================================================================================================");
        Color.printlnColorBlue("КОНСОЛЬНЫЙ МАГАЗИН");
        Color.printlnColorBlue(str);
        Color.printlnColorBlue("==================================================================================================================================================");
    }

    //нижняя панель
    private void printFooter(String str) {
        System.out.println("...................................................................................................................................................");
        Color.printlnColorGreen(str);
    }

    //Загружает главную страницу
    private void loadPageMaster() {
        printHeadline("Главная страница");
        System.out.println(" ТЕЛЕВИЗОРЫ                                        ХОЛОДИЛЬНИКИ                                      СТИРАЛЬНЫЕ МАШИНЫ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

        activePage = PAGE_MASTER;

        int cnt = televisors.length;
        cnt = Math.max(cnt, refrigerators.length);
        cnt = Math.max(cnt, washers.length);


        for (int i = 0; i < cnt; i++) {
            if(i < televisors.length) {
                System.out.printf("%2d. %-45s ", i + 1, televisors[i].getStrInfo());
            }
            else {
                System.out.printf("%50s", "");
            }

            if (i < refrigerators.length) {
                System.out.print("|");
                System.out.printf("%2d. %-45s ", i + 1, refrigerators[i].getStrInfo());
            }
            else {
                System.out.printf("|%50s", "");
            }

            if (i < washers.length) {
                System.out.print("|");
                System.out.printf("%2d. %-45s ", i + 1, washers[i].getStrInfo());
            }

            System.out.println();
        }
        String FOOTER_STR_CMD_MASTER = "Команды: 1 - Телевизоры,  2 - Холодильники, 3 - Стиральные машины, 4 - Корзина     [0 - ВЫХОД]";
        printFooter(FOOTER_STR_CMD_MASTER);
    }

    //загружает страницу с категорией товаров
    private void loadPageCategory(int type) {
        if(type < 0 || type >= 3) {
            Color.printlnColorYellow("Ошибка 404: страница не найдена");
            return;
        }

        prevPage = activePage;
        activePage = type + 1;

        Product[][] products = {televisors, refrigerators, washers};
        String[] categoryName= {"ТЕЛЕВИЗОРЫ", "ХОЛОДИЛЬНИКИ", "СТИРАЛЬНЫЕ МАШИНЫ"};

        printHeadline("Категория товара: " + categoryName[type]);

        //краткие характеристики товара
        for (int i = 0; i < products[type].length; i++) {
            System.out.print((i + 1) + ". ");
            products[type][i].printSmallInfo();
        }

        String FOOTER_STR_CMD_CATEGORY = "Команды: 0 - Главная страница,  НОМЕР_ТОВАРА - посмотреть характеристики товара     ";
        printFooter(FOOTER_STR_CMD_CATEGORY);
    }

    //загружает страницу с корзиной
    private void loadPageBasket() {
        prevPage = activePage;
        activePage = PAGE_BASKET;

        printHeadline("КОРЗИНА ЗАКАЗОВ");
        basket.info();
        String FOOTER_STR_CMD_BASKET = "Команды: 0 - Главная страница,  НОМЕР_ТОВАРА - Удалить товар из корзины     ";
        printFooter(FOOTER_STR_CMD_BASKET);

    }

    //загружает страницу со спецификацией товара
    private void loadPageSpecification(Product prod) {

        prevPage = activePage;
        activePage = PAGE_SPECIFICATION;
        curProd = prod;

        printHeadline("СПЕЦИФИКАЦИЯ ТОВАРА");
        System.out.println(prod.getProductCategory());
        prod.printInfo();
        String FOOTER_STR_SPECIFICATION = "Команды: 0 - Вернуться назад,  1 - добавитиь товар в корзину,  2 - перейти в корзину,  3 - главная страница     ";
        printFooter(FOOTER_STR_SPECIFICATION);
    }

    //загрузить страницу по номеру
    private void loadPageNum(int num) {
        switch (num) {
            case PAGE_MASTER:
                loadPageMaster();
                break;
            case PAGE_TELEVISOR:
                loadPageCategory(PAGE_TELEVISOR - 1);
                break;
            case PAGE_REFRIGERATOR:
                loadPageCategory(PAGE_REFRIGERATOR - 1);
                break;
            case PAGE_WASHER:
                loadPageCategory(PAGE_WASHER - 1);
                break;
            case PAGE_BASKET:
                loadPageBasket();
                break;
            case PAGE_SPECIFICATION:
                //???
                break;

            default:
                break;
        }
    }

    private void loadPrevPage() { //работает только при возврате из спецификации на категорию товара
        loadPageNum(prevPage);
    }

}
