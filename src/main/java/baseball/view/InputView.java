package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String inputRestartNum() {
        return Console.readLine();
    }
}
