package baseball.View;

import java.util.List;

public class OutputView {
    private final static String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String BALL = "볼 ";
    private final static String STRIKE = "스트라이크";
    private final static String NOTHING = "낫싱";
    public static void startMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void gameOverMessage() {
        System.out.println(WIN_MESSAGE);
    }

    public static void showUserInputResult(List<Integer> compareResult) {
        String inputResult = "";
        if (compareResult.get(0) != 0) {
            inputResult += compareResult.get(0) + BALL;
        }
        if (compareResult.get(1) != 0) {
            inputResult += compareResult.get(1) + STRIKE;
        }
        if (inputResult == "") {
            inputResult = NOTHING;
        }
        System.out.println(inputResult);
    }


}
