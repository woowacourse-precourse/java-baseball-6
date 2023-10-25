package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ASK_CONTINUE_MESSAGE = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.";

    public static String requestNumbersInput() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public static String requestPlayerRetryInput(int retryNumber, int exitNumber) {
        System.out.printf(ASK_CONTINUE_MESSAGE, retryNumber, exitNumber);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
