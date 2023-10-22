package baseball.view;

public class OutputView {

    private static final int NO_COUNT = 0;
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printInputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public void printResult(final int ballCount, final int strikeCount) {
        if (isOut(ballCount, strikeCount)) {
            printResult(NOTHING);
            return;
        }

        printResult(buildStatus(ballCount, strikeCount));
    }

    private boolean isOut(final int ballCount, final int strikeCount) {
        return ballCount == NO_COUNT && strikeCount == NO_COUNT;
    }

    private String buildStatus(final int ballCount, final int strikeCount) {
        StringBuilder status = new StringBuilder();
        appendIfNonZero(status, ballCount, BALL);
        appendIfNonZero(status, strikeCount, STRIKE);

        return status.toString();
    }

    private void appendIfNonZero(final StringBuilder status, final int count, final String symbol) {
        if (hasCount(count)) {
            status.append(count)
                    .append(symbol);
        }
    }

    private boolean hasCount(final int count) {
        return count != NO_COUNT;
    }

    private void printResult(final String result) {
        System.out.println(result);
    }

    public void printEnd() {
        System.out.println(END_MESSAGE);
    }

    public void printRestart() {
        System.out.println(RESTART_MESSAGE);
    }
}
