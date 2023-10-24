package baseball.view;

import static baseball.util.CommandValidator.validateRestartNumber;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public String readGameNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String readRestartOrEndGame() {
        OutputView.printRestartOrEnd();

        String input = Console.readLine();
        validateRestartNumber(input);
        return input;
    }
}
