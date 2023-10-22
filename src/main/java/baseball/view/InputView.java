package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String inputNumberMessage = "숫자를 입력해주세요 : ";

    public String enterGameNumber() {
        System.out.print(inputNumberMessage);
        return Console.readLine();
    }

}
