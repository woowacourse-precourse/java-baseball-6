package baseball.ui;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }
}
