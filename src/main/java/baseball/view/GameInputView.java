package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.error.ErrorMessage.INVALID_NUMBER_INPUT;
import static baseball.error.ErrorMessage.INVALID_RESTART_INPUT;

public class GameInputView {

    public static List<Integer> inputUserAnswers() {
        System.out.print("숫자를 입력해주세요 : ");
        String userAnswer = inputNumericString();
        return userAnswer.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    public static boolean getShouldProgramExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = inputNumericString();

        if (input.equals("1")) {
            return false;
        }
        if (input.equals("2")) {
            return true;
        }

        throw new IllegalArgumentException(INVALID_RESTART_INPUT);
    }

    private static String inputNumericString() {
        String input = Console.readLine();
        validateNumericString(input);
        return input;
    }

    private static void validateNumericString(String s) {
        boolean isNumeric = s.chars()
                .allMatch(Character::isDigit);

        if (!isNumeric) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT);
        }
    }
}
