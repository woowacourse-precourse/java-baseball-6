package baseball.ui;

import baseball.dto.Inning;

public class OutputView {
    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(Inning inning) {
        System.out.println(inning.result());
    }
}
