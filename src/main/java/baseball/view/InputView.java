package baseball.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ASK_CONTINUE_MESSAGE = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.";
    private static final Scanner console = new Scanner(System.in);

    public static String requestNumbersInput() {
        System.out.println(INPUT_NUMBERS_MESSAGE);
        return console.nextLine();
    }

    public static String requestPlayerRetryInput(int retryNumber, int exitNumber) {
        System.out.printf((ASK_CONTINUE_MESSAGE) + "%n", retryNumber, exitNumber);
        return console.nextLine();
    }
}
