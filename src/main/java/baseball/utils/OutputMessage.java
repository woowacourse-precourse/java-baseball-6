package baseball.utils;

public class OutputMessage {

    private static final String INTRO = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ASK_NUMBER = "숫자를 입력해주세요 : ";
    private static final String SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public static void printIntroMessage() {
        System.out.println(INTRO);
    }

    public static void askRestartMessage() {
        System.out.println(ASK_RESTART);
    }

    public static void askNumberMessage() {
        System.out.print(ASK_NUMBER);
    }

    public static void printSuccessMessage() {
        System.out.println(SUCCESS);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static String getResultMessage(int ball, int strike) {
        String ballMessage = getBallMessage(ball);
        String strikeMessage = getStrikeMessage(strike);
        if (ballMessage.isEmpty() && strikeMessage.isEmpty()) {
            return NOTHING;
        }
        if (strikeMessage.isEmpty()) {
            return ballMessage;
        }
        if (ballMessage.isEmpty()) {
            return strikeMessage;
        }
        return ballMessage + " " + strikeMessage;
    }

    private static String getBallMessage(int ball) {
        if (ball == 0) {
            return "";
        }
        return ball + BALL;
    }

    private static String getStrikeMessage(int strike) {
        if (strike == 0) {
            return "";
        }
        return strike + STRIKE;
    }
}
