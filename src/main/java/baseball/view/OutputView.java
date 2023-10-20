package baseball.view;

import baseball.model.Score;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";


    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(Score score) {
        System.out.println(score.toString());
    }

    public void printGameEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }
}
