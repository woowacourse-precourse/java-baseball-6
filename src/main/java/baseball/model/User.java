package baseball.model;

import baseball.Key;
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
            throw new IllegalArgumentException("잘못된 입력입니다.");
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
