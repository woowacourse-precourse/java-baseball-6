package baseball.view;

import baseball.domain.GameResult;

public class OutputView {
    private final static String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printResult(GameResult result) {
        System.out.println(result);
    }

    public void printGameFinish() {
        System.out.println(GAME_FINISH_MESSAGE);
    }
}