package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class inputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public static String getInputNumberMessage() {
        System.out.println(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }


}
