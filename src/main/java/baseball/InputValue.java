package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputValue {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CLEAR_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static Validator validator = new Validator();

    public InputValue() {}

    public String inputAnswer() {
        System.out.print(INPUT_MESSAGE);
        String inputNumber = Console.readLine();

        if (!validator.isValidNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }

        return inputNumber;
    }

    public boolean restartCheck() {
        System.out.println(CLEAR_MESSAGE);
        String inputNumber = Console.readLine();

        if (!validator.isOneOrTwo(inputNumber)) {
            throw new IllegalArgumentException();
        }

        return 1 == Integer.parseInt(inputNumber);
    }

}
