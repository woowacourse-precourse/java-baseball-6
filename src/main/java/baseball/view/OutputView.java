package baseball.view;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOT_THING = "낫싱";
    private static final String BLANK = " ";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    // TODO: 과연 여기서 낫싱 여부를 체크하는게 맞는지 고민
    public void printResult(int strikeCount, int ballCount) {
        StringBuilder builder = new StringBuilder();
        if (ballCount == 0 && strikeCount == 0) {
            builder.append(NOT_THING);
        }
        if (ballCount > 0) {
            builder.append(ballCount);
            builder.append(BALL);
            builder.append(BLANK);
        }
        if (strikeCount > 0) {
            builder.append(strikeCount);
            builder.append(STRIKE);
        }
        System.out.println(builder);
    }

    public void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }
}
