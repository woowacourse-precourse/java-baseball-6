package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_LENGTH = 3;

    public static String generate() {
        List<Integer> pickedNumbers = new ArrayList<>(NUMBER_LENGTH);

        while(pickedNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = pickRandomNumber();

            if (!pickedNumbers.contains(randomNumber)) {
                pickedNumbers.add(randomNumber);
            }
        }

        return joinToString(pickedNumbers);
    }

    private static int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    private static String joinToString(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }

        return sb.toString();
    }

    private RandomNumberGenerator() {
    }
}
