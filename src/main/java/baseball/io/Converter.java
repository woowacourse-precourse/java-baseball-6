package baseball.io;

import java.util.ArrayList;
import java.util.LinkedList;

public final class Converter {

    public static Integer convertIntWithRange(String input, Integer min, Integer max) {
        Integer number = convertToInt(input);
        Validator.validateNumberRange(number, min, max);
        return number;
    }

    public static ArrayList<Integer> convertToUniqueIntList(String input, Integer length) {
        Validator.validateDigit(input, length);
        int number = convertToInt(input);

        ArrayList<Integer> result = convertToIntList(number);
        Validator.validateUniqueElements(result);
        return result;
    }


    private static Integer convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The input data is not a valid number");
        }
    }

    private static ArrayList<Integer> convertToIntList(Integer number) {
        LinkedList<Integer> result = new LinkedList<>();

        while (number > 0) {
            result.add(0, number % 10);
            number /= 10;
        }

        return new ArrayList<>(result);
    }

    private Converter() {
    }
}
