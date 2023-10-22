package utils;

import static utils.GameConstant.BASEBALL_GAME_NUMBER_LENGTH;
import static utils.GameErrorMessage.INVALID_LENGTH_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumberUtils {

    private BaseballNumberUtils() {
    }

    public static boolean isValidBaseballNumber(String input) {
        if (input == null) {
            return false;
        }

        if (input.length() != BASEBALL_GAME_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }

        List<Integer> numbers = new ArrayList<>();

        for (char c : input.toCharArray()) {
            int number = Character.getNumericValue(c);
            if (numbers.contains(number)) {
                return false;
            }
            numbers.add(number);
        }
        return true;
    }

    public static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < BASEBALL_GAME_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public static List<Integer> createBaseballNumber(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            int number = Character.getNumericValue(c);
            numbers.add(number);
        }
        return numbers;
    }
}
