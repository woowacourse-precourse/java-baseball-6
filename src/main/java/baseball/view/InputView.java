package baseball.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        return scanner.nextLine();
    }
}
