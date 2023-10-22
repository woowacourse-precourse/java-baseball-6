package baseball.view;

import baseball.validation.ValidateDuplicatedNumber;
import baseball.validation.ValidateNumberFormat;
import baseball.validation.ValidateRetryCheckNumber;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public int inputNumber() {
        String input = "";
        System.out.printf(NUMBER_INPUT_MESSAGE+"%s",input);
        input = Console.readLine();
        validateInputValue(input);
      return Integer.parseInt(input);
    }

    private void validateInputValue(String value) {
        ValidateNumberFormat.validate(value);
        ValidateDuplicatedNumber.validate(value);
    }

    public int retryCheckNumber() {
        String input = Console.readLine();
        ValidateRetryCheckNumber.validate(input);
        return Integer.parseInt(input);
    }
}
