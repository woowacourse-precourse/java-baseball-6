package baseball.view;

public class GameView {
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String ASK_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String SUCCESS_AND_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final String BALL_RESULT = "볼";
    private final String STRIKE_RESULT = "스트라이크";
    private final String NOTHING_RESULT = "낫싱";
    private final String BLANK = " ";


    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printAskInputMessage() {
        System.out.println(ASK_INPUT_MESSAGE);
    }

    public void printSuccessAndEndMessage() {
        System.out.println(SUCCESS_AND_END_MESSAGE);
    }

    public void printRestartOrEndMessage() {
        System.out.println(RESTART_OR_END_MESSAGE);
    }

    public void printResultNothing() {
        System.out.println(NOTHING_RESULT);
    }

    public void printResultStrike(int strikeCount) {
        System.out.println(strikeCount + STRIKE_RESULT);
    }

    public void printResultBall(int ballCount) {
        System.out.println(ballCount + BALL_RESULT + BLANK);
    }

}
