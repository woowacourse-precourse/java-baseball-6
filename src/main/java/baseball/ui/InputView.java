package baseball.ui;

import baseball.validator.InputValidator;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    private final InputValidator validator;

    public InputView(InputValidator validator) {
        this.validator = validator;
        this.scanner = new Scanner(System.in);
    }

    public String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();
        validator.validate(input);
        return input;
    }

    public String inputContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        validator.validate(input);
        return input;
    }
}
