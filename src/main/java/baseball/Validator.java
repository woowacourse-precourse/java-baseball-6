package baseball;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Validator {

    public static List<Integer> checkThreeNumbers(String inputNumbers) {

        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> saveThreeNumbers = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            try {
                int convertInt = checkConvertInt(inputNumbers.charAt(i));
                saveThreeNumbers.add(convertInt);

            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }

        if(!checkDuplication(saveThreeNumbers)){
            throw new IllegalArgumentException();
        }

        return saveThreeNumbers;
    }

    private static int checkZeroToNine(int targetNumber) {
        if (targetNumber < 1 || 9 < targetNumber) {
            throw new IllegalArgumentException();
        }
        return targetNumber;
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

    private static int checkConvertInt(char inputNumber){
        int convertInt = Character.getNumericValue(inputNumber);
        checkZeroToNine(convertInt);

        return convertInt;
    }
}
