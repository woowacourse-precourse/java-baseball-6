package baseball.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력 받는 역할
 */
public class InputView {

    /**
     * 숫자를 입력받는다.
     */
    public String inputNumber() {
        return Console.readLine();
    }

    /**
     * 게임이 끝난 경우 재시작/종료 여부를 입력받는다.
     */
    public String inputRetryOrEndCommand() {
        return Console.readLine();
    }
}
