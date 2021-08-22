public class My {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String[] COLORS_FONT ={
            ANSI_RESET,
            ANSI_BLACK,
            ANSI_RED,
            ANSI_GREEN,
            ANSI_YELLOW,
            ANSI_BLUE,
            ANSI_PURPLE,
            ANSI_CYAN,
            ANSI_WHITE
    };
    //
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String[] COLORS_BACKGROUND ={

            ANSI_BLACK_BACKGROUND,
            ANSI_RED_BACKGROUND,
            ANSI_GREEN_BACKGROUND,
            ANSI_YELLOW_BACKGROUND,
            ANSI_BLUE_BACKGROUND,
            ANSI_PURPLE_BACKGROUND,
            ANSI_CYAN_BACKGROUND,
            ANSI_WHITE_BACKGROUND
    };

    private My(){

    }

    public static void printColor(String strPrint, String color){
        System.out.print(color + strPrint + ANSI_RESET);
    }

    public static void printlnColor(String strPrint, String color){
        System.out.println(color + strPrint + ANSI_RESET);
    }

    public static void printColorYellow(String strPrint) {
        printColor(strPrint, ANSI_YELLOW);
    }

    public static void printlnColorYellow(String strPrint) {
        printlnColor(strPrint, ANSI_YELLOW);
    }

    public static void printColorBlue(String strPrint) {
        printColor(strPrint, ANSI_BLUE);
    }

    public static void printlnColorBlue(String strPrint) {
        printlnColor(strPrint, ANSI_BLUE);
    }


    public static void printColorGreen(String strPrint) {
        printColor(strPrint, ANSI_GREEN);
    }

    public static void printlnColorGreen(String strPrint) {
        printlnColor(strPrint, ANSI_GREEN);
    }


    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
