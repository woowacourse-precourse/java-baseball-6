package baseball.view;

import static baseball.util.Constant.BASEBALL_GAME_NUMBER_DIGIT;

public class ConsoleOutputView implements OutputView {

    private static final int ZERO = 0;
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String BLANK = " ";
    private static final String NEW_LINE = "\n";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다." + NEW_LINE;
    private static final String GUESS_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WINNING_MESSAGE =
            BASEBALL_GAME_NUMBER_DIGIT.getValue() + "개의 숫자를 모두 맞히셨습니다! 게임 종료" + NEW_LINE;
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + NEW_LINE;

    @Override
    public void printStartMessage() {
        System.out.print(START_MESSAGE);
    }

    @Override
    public void printGuessNumberInputMessage() {
        System.out.print(GUESS_NUMBER_INPUT_MESSAGE);
    }

    @Override
    public void printWinningMessage() {
        System.out.print(WINNING_MESSAGE);
    }

    @Override
    public void printRestartOrEndMessage() {
        System.out.print(RESTART_OR_END_MESSAGE);
    }

    @Override
    public void printGameResult(final int ballCount, final int strikeCount) {
        String result = makeResult(ballCount, strikeCount);
        System.out.println(result);
    }


    private String makeResult(final int ballCount, final int strikeCount) {
        StringBuilder stringBuilder = new StringBuilder();

        appendIfOnlyBall(ballCount, strikeCount, stringBuilder);
        appendIfOnlyStrike(ballCount, strikeCount, stringBuilder);
        appendIfNothing(ballCount, strikeCount, stringBuilder);

        if (isEmptyOf(stringBuilder)) {
            appendWithBallsAndStrikes(ballCount, strikeCount, stringBuilder);
        }
        return stringBuilder.toString();
    }

    private void appendIfOnlyBall(final int ballCount, final int strikeCount, final StringBuilder stringBuilder) {
        if (isOnlyBall(ballCount, strikeCount)) {
            String result = ballCount + BALL;
            stringBuilder.append(result);
        }
    }

    private boolean isOnlyBall(final int ballCount, final int strikeCount) {
        return ballCount != ZERO && strikeCount == ZERO;
    }

    private void appendIfOnlyStrike(final int ballCount, final int strikeCount, final StringBuilder stringBuilder) {
        if (isOnlyStrike(ballCount, strikeCount)) {
            String result = strikeCount + STRIKE;
            stringBuilder.append(result);
        }
    }

    private boolean isOnlyStrike(final int ballCount, final int strikeCount) {
        return ballCount == ZERO && strikeCount != ZERO;
    }

    private void appendIfNothing(final int ballCount, final int strikeCount, final StringBuilder stringBuilder) {
        if (isNothing(ballCount, strikeCount)) {
            stringBuilder.append(NOTHING);
        }
    }

    private boolean isNothing(final int ballCount, final int strikeCount) {
        return ballCount == ZERO && strikeCount == ZERO;
    }

    private boolean isEmptyOf(final StringBuilder stringBuilder) {
        return stringBuilder.length() == ZERO;
    }

    private void appendWithBallsAndStrikes(final int ballCount, final int strikeCount,
                                           final StringBuilder stringBuilder) {
        String result = ballCount + BALL + BLANK + strikeCount + STRIKE;
        stringBuilder.append(result);
    }
}
