package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readGuessNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    protected String readLine() {
        return Console.readLine();
    }
}
