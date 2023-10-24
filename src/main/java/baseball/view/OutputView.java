package baseball.view;

import baseball.dto.response.GameResultDto;

public class OutputView {

    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private static final String NOTHING_MESSAGE = "낫싱\n";
    private static final String BALL_COUNT_MESSAGE_FORMAT = "%d볼\n";
    private static final String BALL_AND_STRIKE_MESSAGE_FORMAT = "%d볼 %d스트라이크\n";
    private static final String STRIKE_COUNT_MESSAGE_FORMAT = "%d스트라이크\n";
    private static final int ZERO_STRIKE_COUNT = 0;
    private static final int ZERO_BALL_COUNT = 0;
    private static final int THREE_STRIKE_COUNT = 3;

    private OutputView() {
    }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printGameStartMessage() {
        System.out.printf(GAME_START_MESSAGE);
    }

    public void printGameResult(GameResultDto gameResultDto) {
        int ballCount = gameResultDto.getBallCount();
        int strikeCount = gameResultDto.getStrikeCount();
        if (isNothing(ballCount, strikeCount)) {
            printNothingResultMessage();
            return;
        }

        if (isOnlyBall(ballCount, strikeCount)) {
            printOnlyBall(ballCount);
            return;
        }

        if (isBallAndStrike(ballCount, strikeCount)) {
            printBallAndStrike(ballCount, strikeCount);
            return;
        }

        if (isOnlyStrike(ballCount, strikeCount)) {
            printOnlyStrike(strikeCount);
            return;
        }

        if (isThreeStrike(ballCount, strikeCount)) {
            printThreeStrikes(strikeCount);
        }
    }

    private boolean isNothing(int ballCount, int strikeCount) {
        return ballCount == ZERO_BALL_COUNT && strikeCount == ZERO_STRIKE_COUNT;
    }

    private void printNothingResultMessage() {
        System.out.printf(NOTHING_MESSAGE);
    }

    private boolean isOnlyBall(int ballCount, int strikeCount) {
        return ballCount > ZERO_BALL_COUNT && strikeCount == ZERO_STRIKE_COUNT;
    }

    private void printOnlyBall(int ballCount) {
        System.out.printf(BALL_COUNT_MESSAGE_FORMAT, ballCount);
    }

    private boolean isBallAndStrike(int ballCount, int strikeCount) {
        return ballCount > ZERO_BALL_COUNT && strikeCount > ZERO_STRIKE_COUNT && strikeCount < THREE_STRIKE_COUNT;
    }

    private void printBallAndStrike(int ballCount, int strikeCount) {
        System.out.printf(BALL_AND_STRIKE_MESSAGE_FORMAT, ballCount, strikeCount);
    }

    private boolean isOnlyStrike(int ballCount, int strikeCount) {
        return ballCount == ZERO_BALL_COUNT && strikeCount > ZERO_STRIKE_COUNT && strikeCount < THREE_STRIKE_COUNT;
    }

    private void printOnlyStrike(int strikeCount) {
        System.out.printf(STRIKE_COUNT_MESSAGE_FORMAT, strikeCount);
    }

    private boolean isThreeStrike(int ballCount, int strikeCount) {
        return ballCount == ZERO_BALL_COUNT && strikeCount == THREE_STRIKE_COUNT;
    }

    private void printThreeStrikes(int strikeCount) {
        System.out.printf(STRIKE_COUNT_MESSAGE_FORMAT, strikeCount);
        System.out.print(GAME_END_MESSAGE);
    }

    private static class LazyHolder {

        private static final OutputView INSTANCE = new OutputView();

    }

}
