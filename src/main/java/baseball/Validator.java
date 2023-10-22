package baseball;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static List<Integer> checkThreeNumbers(String inputNumbers) {

        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> saveThreeNumbers = new ArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            try {
                char convertChar = inputNumbers.charAt(i);
                int convertInt = Character.getNumericValue(convertChar);
                checkZeroToNine(convertInt);
                saveThreeNumbers.add(convertInt);

            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
        }
        // TODO : 중복 처리 로직 추가

        return saveThreeNumbers;
    }

    private static int checkZeroToNine(int targetNumber) {
        if (targetNumber < 0 || 9 < targetNumber){
            throw new IllegalArgumentException();
        }
        return targetNumber;
    }
}
