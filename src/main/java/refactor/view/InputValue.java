package refactor.view;

import camp.nextstep.edu.missionutils.Console;
import refactor.exception.Validator;

public class InputValue {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CLEAR_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private String inputNumber;

    public InputValue() {}

    public String inputAnswer() {
        System.out.print(INPUT_MESSAGE);
        inputNumber = Console.readLine();

        Validator.isValidNumber(inputNumber);

        return inputNumber;
    }

    public boolean restartCheck() {
        System.out.println(CLEAR_MESSAGE);
        inputNumber = Console.readLine();

        Validator.isOneOrTwo(inputNumber);

        return 1 == Integer.parseInt(inputNumber);
    }

}
