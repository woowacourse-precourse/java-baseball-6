package baseball.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String receiveInputNumber() {
        return scanner.nextLine();
    }

    public int receiveRetryOption() {
        return Integer.parseInt(scanner.nextLine());
    }
}
