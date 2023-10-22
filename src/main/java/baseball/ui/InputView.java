package baseball.ui;

import baseball.enums.GameConfig;
import baseball.validator.InputValidator;
import java.util.Scanner;

public class InputView {
    private static final int RESTART_SIZE = 1;
    private final Scanner scanner;
    private final InputValidator validator;

    public InputView(InputValidator validator) {
        this.validator = validator;
        this.scanner = new Scanner(System.in);
    }

    public String scanNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();
        validator.validate(input, GameConfig.PITCH_COUNT.getValue());
        return input;
    }

    public String scanRestartNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        validator.validate(input, RESTART_SIZE);
        return input;
    }
}
