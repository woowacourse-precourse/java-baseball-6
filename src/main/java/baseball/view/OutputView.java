package baseball.view;

import baseball.model.NumberBaseballResult;
import camp.nextstep.edu.missionutils.Console;

public class OutputView {
    public static final String GAME_END_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String REAL_GAME_END_MESSAGE = "게임 종료";

    private OutputView() {

    }

    public static OutputView getInstance() {
        return new OutputView();
    }

    public void printGameResult(NumberBaseballResult numberBaseballResult) {
        System.out.println(numberBaseballResult.generateResultString());
    }

    public void printEndGame() {
        System.out.println(GAME_END_MESSAGE);
    }

    public void endOfGame() {
        System.out.println(REAL_GAME_END_MESSAGE);
    }
}
