package baseball.ui;

import baseball.dto.Inning;
import baseball.enums.GameConfig;

public class OutputView {
    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(Inning inning) {
        System.out.println(inning.result());
    }

    public void printGameEndMessage() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", GameConfig.PITCH_COUNT.getValue());
    }
}
