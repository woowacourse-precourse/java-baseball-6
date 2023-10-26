package baseball.view.console;

import baseball.domain.Baseball;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printRoundResult(String result) {
        System.out.println(result);
    }

    public void printGameEndMessage() {
        System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Baseball.NUMBERS_COUNT));
    }
}
