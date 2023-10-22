package baseball.view;

import baseball.domain.ClientNumbers;
import camp.nextstep.edu.missionutils.Console;


public class InputView {
    private static final String INPUT_MSG = "숫자를 입력해주세요 : ";

    public static void printInputMsg() {
        System.out.print(INPUT_MSG);
    }

    public static ClientNumbers makeClientNumbers() {
        String inputStr = Console.readLine();
        ClientNumbers clientNumbers = new ClientNumbers(inputStr);
        return clientNumbers;
    }
}
