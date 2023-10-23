package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {
    public static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
