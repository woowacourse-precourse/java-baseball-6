package baseball.view;

public class OutputView {

    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printCorrectAnswer() {
        System.out.println(THREE_STRIKE_MESSAGE);
    }

    public static void printResultMessage(String result) {
        System.out.println(result);
    }
}
