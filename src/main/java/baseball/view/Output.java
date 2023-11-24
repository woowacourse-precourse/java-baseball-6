package baseball.view;

public class Output {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void showStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void showEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public void showResult(int strike, int ball) {
        String result = NOTHING;
        if (ball > 0 && strike > 0) {
            result = ball + BALL + " " + strike + STRIKE;
        }
        if (ball > 0 && strike == 0) {
            result = ball + BALL;
        }
        if (ball == 0 && strike > 0) {
            result = strike + STRIKE;
        }
        System.out.println(result);
    }

    private String format(String format, Object... args) {
        return String.format(format, args);
    }
}
