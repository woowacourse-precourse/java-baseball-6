package baseball.view;

import baseball.view.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BALL_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_OPTION_NUMBER_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputBallNumbers() {
        System.out.print(INPUT_BALL_NUMBERS_MESSAGE);
        String input = Console.readLine();

        Validator.validateBallNumbers(input);
        return input;
    }

    public int inputRestartOptionNumber() {
        System.out.println(INPUT_RESTART_OPTION_NUMBER_MESSAGE);
        String input = Console.readLine();

        Validator.validateRestartOptionNumber(input);
        return Integer.parseInt(input);
    }
}
