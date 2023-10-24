package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readInputNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String readRestartOrOver() {
        return Console.readLine();
    }
}
