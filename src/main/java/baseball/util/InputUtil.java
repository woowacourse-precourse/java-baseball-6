package baseball.process;

import camp.nextstep.edu.missionutils.Console;
import baseball.validation.ValidationNumber;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    private final String NUMBER_TYPE_ERROR_MESSAGE = "숫자만 입력해주세요.";
    private InputNumber() {
    }

    public static InputNumber of() {
        return new InputNumber();
    }

    public List<Integer> inputNumber() {
        System.out.print(ApplicationConstant.INPUT_NUMBER_MESSAGE);
        String input = Console.readLine();
        return getNumbers(input);
    }

    public int inputStatus() {
        System.out.print(ApplicationConstant.INPUT_RESTART_MESSAGE);
        String input = Console.readLine();
        return getStatus(input);
    }

    public List<Integer> getNumbers(String input) {
        List<Integer> playerNumber = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            String value = String.valueOf(ch);
            int num = stringToInt(value);
            playerNumber.add(num);
        }
        ValidationNumber.validateNumbers(playerNumber);
        return playerNumber;
    }

    public int getStatus(String input) {
        int status = stringToInt(input);
        ValidationNumber.validationStatus(status);
        return status;
    }

    public int stringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionConstant.NUMBER_TYPE_ERROR_MESSAGE);
        }
    }

}
