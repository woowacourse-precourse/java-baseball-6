package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    /* 게임 시작 */
    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        final int numberLength = 3;
        Answer answer = new Answer(numberLength);
        String message;
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userAnswer = Console.readLine();
            checkInputValue(userAnswer, numberLength);
            int[] result = answer.getStatusArray(userAnswer);
            Status status = new Status(result);
            message = status.toString();
            System.out.println(message);
            if (status.isCorrect())
                break;
        }
        Console.close();
    }
    /* 입력 값 정상여부 확인 */
    private static void checkInputValue (String userAnswer, int numberLength) {
        if (userAnswer.length() != numberLength)
            throw new IllegalArgumentException();
    }
}
