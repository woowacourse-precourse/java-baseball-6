package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static String getUserNumber() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

}
