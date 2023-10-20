package baseball.util.view;

public abstract class Printer {
    public static void print(String message) {
        System.out.print(message);
    }
    public static void println() {
        System.out.println();
    }
    public static void println(String message) {
        System.out.println(message);
    }
}
