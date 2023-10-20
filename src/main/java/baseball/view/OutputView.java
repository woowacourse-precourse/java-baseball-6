package baseball.view;

import baseball.dto.response.GameResultDto;

public class OutputView {

    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_COUNT_MESSAGE_FORMAT = "%d볼 ";
    private static final String STRIKE_COUNT_MESSAGE_FORMAT = "%d스트라이크";
    private static final int ZERO_STRIKE_COUNT = 0;
    private static final int ZERO_BALL_COUNT = 0;
    private static final int THREE_STRIKE_COUNT = 3;

    private OutputView() {
    }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameResult(GameResultDto gameResultDto) {
        int ballCount = gameResultDto.getBallCount();
        int strikeCount = gameResultDto.getStrikeCount();
        if (isNothing(ballCount, strikeCount)) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        printResult(ballCount, strikeCount);
    }

    private void printResult(int ballCount, int strikeCount) {
        printIfHasBall(ballCount);
        printIfHasStrike(ballCount, strikeCount);
    }

    private void printIfHasStrike(int ballCount, int strikeCount) {
        if (strikeCount > ZERO_STRIKE_COUNT) {
            System.out.printf(STRIKE_COUNT_MESSAGE_FORMAT, strikeCount);
            printIfEndingMessageIfAllStrike(ballCount, strikeCount);
        }
        printEmptyLine();
    }

    private void printIfEndingMessageIfAllStrike(int ballCount, int strikeCount) {
        if (ballCount == ZERO_BALL_COUNT && strikeCount == THREE_STRIKE_COUNT) {
            printEmptyLine();
            System.out.print(GAME_END_MESSAGE);
        }
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private void printIfHasBall(int ballCount) {
        if (ballCount > ZERO_BALL_COUNT) {
            System.out.printf(BALL_COUNT_MESSAGE_FORMAT, ballCount);
        }
    }

    private boolean isNothing(int ballCount, int strikeCount) {
        return ballCount == ZERO_BALL_COUNT && strikeCount == ZERO_STRIKE_COUNT;
    }

    private static class LazyHolder {

        private static final OutputView INSTANCE = new OutputView();

    }

}
