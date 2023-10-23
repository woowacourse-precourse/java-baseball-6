package baseball.view;

import baseball.domain.ClientNumbers;


public class InputView {
    private static final String INPUT_MSG = "숫자를 입력해주세요 : ";

    private InputView() {}

    public static void printInputMsg() {
        System.out.print(INPUT_MSG);
    }

    public static ClientNumbers makeClientNumbers(String inputStr) {
        ClientNumbers clientNumbers = new ClientNumbers(inputStr);
        return clientNumbers;
    }
}
