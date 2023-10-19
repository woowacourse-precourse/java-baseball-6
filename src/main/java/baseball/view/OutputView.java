package baseball.view;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GET_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NOTHING = "낫싱";
    private static final String BALL_FORMAT = "%d볼 ";
    private static final String STRIKE_FORMAT = "%d스트라이크";


    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printGetInput() {
        System.out.println(GET_INPUT_MESSAGE);
    }

    public static void printResult(boolean isNothing, int ballCount, int strikeCount) {
        if (isNothing) {
            System.out.println(NOTHING);
            return;
        }
        String resultString = "";
        if (ballCount != 0) {
            resultString = String.format(BALL_FORMAT, ballCount);
        }
        if (strikeCount != 0) {
            resultString += String.format(STRIKE_FORMAT, strikeCount);
        }
        System.out.println(resultString);
    }

    public static void printEnd() {
        System.out.println(END_MESSAGE);
    }


}
