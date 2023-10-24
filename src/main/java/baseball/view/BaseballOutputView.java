package baseball.view;

import baseball.domain.Score;

public class BaseballOutputView implements OutputView {

    private static final String START_BASEBALL_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_BASEBALL_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void startGame() {
        System.out.println(START_BASEBALL_GAME_MESSAGE);
    }

    public void endGame() {
        System.out.println(END_BASEBALL_GAME_MESSAGE);
    }

    public void matchResult(Score score) {
        System.out.println(score);
    }
}
