package baseball.utils;

import baseball.constants.Constants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
    }

    public static void addNumber(List<Integer> numbers, int number) {
        if (!isDuplicatedNumber(numbers, number)) {
            numbers.add(number);
        }
    }

    private static boolean isDuplicatedNumber(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }

    public static List<Integer> stringToInt(String input) {
        Validator.validateNotZero(input);
        Validator.validateNumberSize(input);

        List<Integer> numbers = new ArrayList<>();
        for (char num : input.toCharArray()) {
            Validator.validateIsNumber(num);
            int number = charToInt(num);
            Validator.validateDuplicatedNumber(numbers, number);
            numbers.add(number);
        }
        return numbers;
    }

    public static int charToInt(char number) {
        return number - '0';
    }
}
