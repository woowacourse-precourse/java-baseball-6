package baseball.model;

import baseball.Key;
import baseball.exception.BaseballExceptionMassage;
import camp.nextstep.edu.missionutils.Console;

public class User {

    private static String answer;

    public void inputAnswer() {
        answer = Console.readLine();
        checkUserAnswer();
    }

    public String getAnswer() {
        return answer;
    }

    private void checkUserAnswer() {
        if (!isAnswerLengthRight()
                || !isAnswerDigit()
                || isAnswerContainZero()) {
            throw new IllegalArgumentException(BaseballExceptionMassage.NOT_RIGHT_ANSWER);
        }
    }

    private boolean isAnswerLengthRight() {
        return answer.length() == Key.NUMBER_LENGTH;
    }

    private boolean isAnswerDigit() {
        return answer.chars().allMatch(Character::isDigit);
    }

    private boolean isAnswerContainZero() {
        return answer.chars().anyMatch(ch -> ch == '0');
    }
}
