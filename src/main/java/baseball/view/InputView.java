package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void printNumberRequestMessage() {
        System.out.println("숫자를 입력해 주세요 : ");
    }

    public void printRetryMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
