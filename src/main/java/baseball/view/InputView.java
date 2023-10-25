package baseball.view;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static InputException inputException = new InputException();

    public String inputPlayerNumber() {
        System.out.print(INPUT_MESSAGE);
        String playerNumber = Console.readLine();
        inputException.validNumberLength(playerNumber);
        inputException.validNumberType(playerNumber);
        inputException.validDuplicateNumber(playerNumber);
        return playerNumber;
    }

    public String inputGameOption() {
        System.out.println(OPTION_MESSAGE);
        String option = Console.readLine();
        inputException.validOption(option);
        return option;
    }
}
