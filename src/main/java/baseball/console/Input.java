package baseball.console;

import static baseball.validator.InputValidator.checkInput;
import static baseball.validator.InputValidator.isValidRestartNumber;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input;

        try {
            input = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }

        checkInput(input, 3);

        return input;
    }

    public static String chooseRestart() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String input;

        try {
            input = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }

        checkInput(input, 1);
        isValidRestartNumber(input);

        return input;
    }
}
