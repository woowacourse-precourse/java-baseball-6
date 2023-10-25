package baseball.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private final static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final static String NOTHING_MESSAGE = "낫싱";
    private final static String BALL_MESSAGE = "볼";
    private final static String STRIKE_MESSAGE = "스트라이크";
    private final static String CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String GAME_RESTART_OR_OVER_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void startMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void inputMessage() {
        System.out.printf(USER_INPUT_MESSAGE);
    }

    public static void resultCheck(int[] result) {
        int ballCount = result[0];
        int strikeCount = result[1];
        List<String> message = new ArrayList<>();
        if (ballCount == 0 && strikeCount == 0) {
            message.add(NOTHING_MESSAGE);
        }
        if (ballCount != 0) {
            message.add(ballCount + BALL_MESSAGE);
        }
        if (strikeCount != 0) {
            message.add(strikeCount + STRIKE_MESSAGE);
        }
        System.out.println(String.join(" ", message));
    }

    public static void clearMessage() {
        System.out.println(CLEAR_MESSAGE);
    }

    public static void reStartOrOverMessage() {
        System.out.println(GAME_RESTART_OR_OVER_MESSAGE);
    }
}
