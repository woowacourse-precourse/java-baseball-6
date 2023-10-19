package baseball.view;

import baseball.dto.response.GameResultDto;

public class OutputView {

    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_COUNT_MESSAGE_FORMAT = "%d볼 ";
    private static final String STRIKE_COUNT_MESSAGE_FORMAT = "%d스트라이크";

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

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }

        if (ballCount > 0) {
            System.out.printf(BALL_COUNT_MESSAGE_FORMAT, ballCount);
        }

        if (strikeCount > 0) {
            System.out.printf(STRIKE_COUNT_MESSAGE_FORMAT, strikeCount);

            if (ballCount == 0 && strikeCount == 3) {
                System.out.println();
                System.out.print(GAME_END_MESSAGE);
            }
        }

        System.out.println();
    }

    private static class LazyHolder {

        private static final OutputView INSTANCE = new OutputView();

    }

}
