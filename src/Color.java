/*
Цвета: http://surl.li/mrnv
 */

public class Color {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private Color(){

    }

    public static void printColor(String strPrint, String color){
        setTextColor(color);
        System.out.print(strPrint);
        resetTextColor();
    }

    public static void printlnColor(String strPrint, String color){
        printColor(strPrint, color);
        System.out.println();
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

    public static void printColorPurple(String strPrint) {
        printColor(strPrint, ANSI_PURPLE);
    }
    public static void printlnColorPurple(String strPrint) {
        printlnColor(strPrint, ANSI_PURPLE);
    }

    public static void printColorGreen(String strPrint) {
        printColor(strPrint, ANSI_GREEN);
    }
    public static void printlnColorGreen(String strPrint) {
        printlnColor(strPrint, ANSI_GREEN);
    }

    public static void printColorRed(String strPrint) {
        printColor(strPrint, ANSI_RED);
    }
    public static void printlnColorRed(String strPrint) {
        printlnColor(strPrint, ANSI_RED);
    }

    public static void printColorBlack(String strPrint) {
        printColor(strPrint, ANSI_BLACK);
    }
    public static void printlnColorBlack(String strPrint) {
        printlnColor(strPrint, ANSI_BLACK);
    }

    public static void printColorCyan(String strPrint) {
        printColor(strPrint, ANSI_CYAN);
    }
    public static void printlnColorCyan(String strPrint) {
        printlnColor(strPrint, ANSI_CYAN);
    }

    public static void printColorWhite(String strPrint) {
        printColor(strPrint, ANSI_WHITE);
    }
    public static void printlnColorWhite(String strPrint) {
        printlnColor(strPrint, ANSI_WHITE);
    }

    public static void setTextColor(String color){
        System.out.print(color);
    }

    public static void resetTextColor(){
        System.out.print(ANSI_RESET);
    }

}
