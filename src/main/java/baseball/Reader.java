package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private static final String REQUEST_NUMBER = "숫자를 입력해주세요: ";

    public static List<Integer> readNumber(Preference preference) {
        System.out.print(REQUEST_NUMBER);

        String input = Console.readLine();
        int parsedInput = parseInt(input);
        validateRange(preference, parsedInput);

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= preference.answerSize(); i++) {
            int eachDigit = parsedInput / (int) Math.pow(10.0, preference.answerSize() - i) % 10;
            validateDuplicates(result, eachDigit);
            validateEachRange(preference, eachDigit);
            result.add(eachDigit);
        }
        return result;
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(Preference preference, int parsedInput) {
        if (parsedInput < preference.lowerBound() - 1 || parsedInput > Math.pow(10.0, preference.answerSize())) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicates(List<Integer> list, int digit) {
        if (list.contains(digit)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateEachRange(Preference preference, int eachDigit) {
        if (eachDigit < preference.lowerBound() || eachDigit > preference.upperBound()) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkReplay() {
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
