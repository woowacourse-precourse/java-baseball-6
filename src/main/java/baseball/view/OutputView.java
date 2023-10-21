package baseball.view;

import baseball.model.NumberBaseballResult;
import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    public void printGameResult(NumberBaseballResult numberBaseballResult) {
        System.out.println(numberBaseballResult.generateResultString());
    }

    public void printEndGame() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void endOfGame() {
        System.out.println("게임 종료");
    }
}
