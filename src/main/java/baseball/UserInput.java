package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserInput {
    public static final int MAX_DIGITS = 3;

    public static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        validateLength(inputString);
        List<Integer> numbers = convertStringToNumbers(inputString);
        validateDuplicate(numbers);
        return numbers;
    }

    private static List<Integer> convertStringToNumbers(String string) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < MAX_DIGITS; i++) {
            int digit = convertCharToInt(string.charAt(i));
            numbers.add(digit);
        }
        return numbers;
    }

    private static int convertCharToInt(char ch) {
        int digit = Character.getNumericValue(ch);
        validateNonzeroDigit(digit);
        return digit;
    }

    private static void validateLength(String string) {
        if (string.length() != MAX_DIGITS) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNonzeroDigit(int digit) {
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = Set.copyOf(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
