package baseball;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Validator {

    public static List<Integer> checkThreeNumbers(String inputNumbers) {

        checkLength(inputNumbers, 3);

        List<Integer> saveThreeNumbers = new ArrayList<>(3);

        for (int i = 0; i < inputNumbers.length(); i++) {
            int convertInt = checkConvertInt(inputNumbers.charAt(i), 1, 9);
            saveThreeNumbers.add(convertInt);
        }

        if (!checkDuplication(saveThreeNumbers)) {
            throw new IllegalArgumentException();
        }

        return saveThreeNumbers;
    }

    public static int checkEndNumber(String inputNumbers) {
        checkLength(inputNumbers, 1);
        return checkConvertInt(inputNumbers.charAt(0), 1, 2);
    }

    private static void checkLength(String inputNumbers, int length) {
        if (inputNumbers.length() != length) {
            throw new IllegalArgumentException();
        }
    }

    private static int checkConvertInt(char inputNumber, int min, int max) {
        int convertInt = Character.getNumericValue(inputNumber);
        checkRange(convertInt, min, max);

        return convertInt;
    }

    private static void checkRange(int targetNumber, int min, int max) {
        if (targetNumber < min || max < targetNumber) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkDuplication(List<Integer> threeNumbers) {
        List<Integer> sortedThreeNumbers = new ArrayList<>(threeNumbers);
        sortedThreeNumbers.sort(Comparator.naturalOrder());

        for (int i = 0; i < sortedThreeNumbers.size() - 1; i++) {
            if (sortedThreeNumbers.get(i) == sortedThreeNumbers.get(i + 1)) {
                return false;
            }
        }

        return true;
    }


}
