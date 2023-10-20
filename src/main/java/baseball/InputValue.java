package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputValue {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

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

}
