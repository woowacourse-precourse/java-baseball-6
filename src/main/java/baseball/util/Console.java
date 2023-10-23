package baseball.util;

import java.util.Scanner;

public class Console {

    private static Scanner scanner;

    public static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static String readLine(){
        return getInstance().nextLine();
    }

    public static void close() {
        getInstance().close();
    }
}
