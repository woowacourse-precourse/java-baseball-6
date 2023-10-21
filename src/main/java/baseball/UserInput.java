package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        UserInputValidator.validateLength(inputString);
        List<Integer> numbers = convertStringToNumbers(inputString);
        UserInputValidator.validateDuplicate(numbers);
        return numbers;
    }

    private static List<Integer> convertStringToNumbers(String string) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < Constants.MAX_DIGITS; i++) {
            int digit = convertCharToInt(string.charAt(i));
            numbers.add(digit);
        }
        return numbers;
    }

    private static int convertCharToInt(char ch) {
        int digit = Character.getNumericValue(ch);
        UserInputValidator.validateNonzeroDigit(digit);
        return digit;
    }
}
