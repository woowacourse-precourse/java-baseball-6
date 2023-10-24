package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
