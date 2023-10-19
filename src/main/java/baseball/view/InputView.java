package baseball.view;

import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BALL_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    public int inputBallNumbers() {
        System.out.print(INPUT_BALL_NUMBERS_MESSAGE);
        String input = Console.readLine();

        Validator.validateBallNumbers(input);
        return Integer.parseInt(input);
    }
}
