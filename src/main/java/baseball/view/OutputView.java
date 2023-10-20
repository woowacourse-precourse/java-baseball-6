package baseball.view;

import baseball.model.NumberBaseballResult;
import camp.nextstep.edu.missionutils.Console;

public class OutputView {

    public void printGameResult(NumberBaseballResult numberBaseballResult) {
        System.out.println(numberBaseballResult.generateResultString());
    }

    public int printEndGame() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    public void endOfGame() {
        System.out.println("숫자야구 게임이 종료되었습니다.");
    }
}
