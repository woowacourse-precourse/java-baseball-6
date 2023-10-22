package baseball.object;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private static String answer;

    public static String getAnswer() {
        return answer;
    }

    public static void getUserAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        answer = Console.readLine();
        checkUserAnswer();
    }

    private static void checkUserAnswer() {
        if(!isAnswerLengthRight()
                || !isAnswerDigit()
                || isAnswerContainZero())
            throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    private static boolean isAnswerLengthRight() {
        return answer.length() == 3;
    }

    private static boolean isAnswerDigit() {
        return answer.chars().allMatch(Character::isDigit);
    }

    private static boolean isAnswerContainZero() {
        return answer.chars().anyMatch(ch -> ch == '0');
    }
}
