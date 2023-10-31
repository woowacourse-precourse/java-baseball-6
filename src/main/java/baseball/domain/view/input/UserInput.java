package baseball.domain.view.input;

import baseball.domain.util.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private static final String INPUT_BASEBALL_NUMBER_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_OR_QUIT_REQUEST_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String getGamingInput() {
        System.out.print(INPUT_BASEBALL_NUMBER_REQUEST_MESSAGE);
        String userInput = removeSpace(Console.readLine());

        validateGetGamingInput(userInput);

        return userInput;
    }

    public static String getEndGameInput() {
        System.out.println(INPUT_RESTART_OR_QUIT_REQUEST_MESSAGE);
        String userInput = removeSpace(Console.readLine());

        validateGetEndGameInput(userInput);

        return userInput;
    }

    private static String removeSpace(String str) {
        return str.replace(" ", "");
    }

    public static void validateGetGamingInput(String input) {
        InputValidator.checkThreeNumber(input);
        InputValidator.checkOnlyCompositionNumber(input);
        InputValidator.checkDuplicationNumber(input);
    }

    public static void validateGetEndGameInput(String input) {
        InputValidator.checkOnlyTwoNumber(input);
    }

}
