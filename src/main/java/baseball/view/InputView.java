package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String BASEBALL_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CONTINUE_OR_EXIT_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String CONTINUE_NUMBER = "1";

    public static String baseballNumber() {
        System.out.print(BASEBALL_NUMBER_INPUT_MESSAGE);
        return InputValidator.validateBaseballNumber(Console.readLine());
    }

    public static boolean continueOrExit() {
        System.out.println(CONTINUE_OR_EXIT_INPUT_MESSAGE);
        String input = InputValidator.validateContinueOrExitNumber(Console.readLine());
        return input.equals(CONTINUE_NUMBER);
    }
}
