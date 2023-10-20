package baseball.view;

import baseball.model.Score;

import static baseball.constant.NumberConstants.OUT_COUNT;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String RESULT_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! ";
    private static final String GAME_END_MESSAGE = "게임 종료";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printScore(Score score) {
        System.out.println(score.toString());
    }

    public void printGameEndMessage() {
        System.out.printf(RESULT_MESSAGE, OUT_COUNT.getValue());
        System.out.println(GAME_END_MESSAGE);
    }
}
