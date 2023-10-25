package baseball.view;

public class OutputView {

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final int NO_COUNT = 0;

    public void printGameStart() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printHint(int ballCount, int strikeCount) {
        String hint = "";
        if (ballCount > NO_COUNT) {
            hint += ballCount + BALL_MESSAGE;
        }
        if (strikeCount > NO_COUNT) {
            hint += strikeCount + STRIKE_MESSAGE;
        }
        if (hint.isEmpty()) {
            hint = NOTHING_MESSAGE;
        }
        System.out.println(hint);
    }

}
