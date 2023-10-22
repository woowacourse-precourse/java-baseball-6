package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputThreeDigitNumber() {
        return Console.readLine();
    }

    public String inputRestartOrExit() {
        return Console.readLine();
    }

    // TODO: 사용자 입력값 예외 처리, int 형변환
}
