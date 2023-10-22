package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputUserNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        return Console.readLine();
    }
}
