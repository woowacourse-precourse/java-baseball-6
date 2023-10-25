package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.error.ErrorMessage.INVALID_NUMBER_INPUT;

public class GameInputView {

    public static List<Integer> inputUserAnswers() {
        System.out.print("숫자를 입력해주세요 : ");
        String userAnswer = Console.readLine();
        validateNumericString(userAnswer);
        return userAnswer.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    private static void validateNumericString(String s) {
        boolean isNumeric = s.chars()
                .allMatch(Character::isDigit);

        if (!isNumeric) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT);
        }
    }
}
