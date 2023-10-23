package baseball.view;

public class OutputView {

    private static final int NO_COUNT = 0;
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String BLANK = " ";
    private static final String STRIKE = "스트라이크";
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printInputNumbersMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public void printGameResult(final int ballCount, final int strikeCount) {
        if (isNothing(ballCount, strikeCount)) {
            printGameResult(NOTHING);
            return;
        }

        printGameResult(buildStatus(ballCount, strikeCount));
    }

    private boolean isNothing(final int ballCount, final int strikeCount) {
        return !hasCount(ballCount) && !hasCount(strikeCount);
    }

    private String buildStatus(final int ballCount, final int strikeCount) {
        StringBuilder status = new StringBuilder();

        appendIfNonZero(status, ballCount, BALL);
        appendIfNonZero(status, strikeCount, STRIKE);

        return status.toString()
                .trim();
    }

    private void appendIfNonZero(final StringBuilder status, final int count, final String symbol) {
        if (hasCount(count)) {
            status.append(count)
                    .append(symbol)
                    .append(BLANK);
        }
    }

    private boolean hasCount(final int count) {
        return count != NO_COUNT;
    }

    private void printGameResult(final String result) {
        System.out.println(result);
    }

    public void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void printRestartMessage() {
        System.out.println(RESTART_MESSAGE);
    }
}
