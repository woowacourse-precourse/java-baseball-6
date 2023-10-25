package baseball.model;

import baseball.validator.NumberValidator;
import baseball.validator.RestartInputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.validator.NumberValidator.validateConditions;

public class User {
    public List<Integer> inputNumbers() {
        String inputNumbers = Console.readLine();
        NumberValidator.validateConditions(inputNumbers);
        return convertToNumber(inputNumbers);
    }

    public String inputReset() {
        String inputReset = Console.readLine();
        RestartInputValidator.restartInputCondition(inputReset);
        return inputReset;
    }

    private static List<Integer> convertToNumber(String input) {
        List<Integer> convertedNumber = new ArrayList<>();
        for (char number : input.toCharArray()) {
            convertedNumber.add(Character.getNumericValue(number));
        }
        return convertedNumber;
    }


}
