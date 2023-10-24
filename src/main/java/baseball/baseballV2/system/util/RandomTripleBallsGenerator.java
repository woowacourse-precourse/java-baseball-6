package baseball.baseballV2.system.util;

import static baseball.baseballV2.system.util.Util.FIRST_DIGIT;

import baseball.baseballV2.model.Ball;
import baseball.baseballV2.model.TripleBalls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTripleBallsGenerator {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;
    private static final Random random = ThreadLocalRandom.current();

    public static TripleBalls generate() {
        List<Integer> randomNumbers = generateThreeRandomNumbers();
        return new TripleBalls(
                getTripleBalls(randomNumbers, FIRST_DIGIT)
        );
    }

    private static List<Ball> getTripleBalls(List<Integer> randomNumbers, int digit) {
        return Arrays.asList(new Ball(digit, randomNumbers.get(digit++)),
                new Ball(digit, randomNumbers.get(digit++)),
                new Ball(digit, randomNumbers.get(digit)));
    }

    private static List<Integer> generateThreeRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != Util.VALID_INPUT_SIZE) {
            int pickedNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!haveDuplicatedNumber(numbers, pickedNumber)) {
                numbers.add(pickedNumber);
            }
        }
        return numbers;
    }

    private static boolean haveDuplicatedNumber(List<Integer> numbers, int pickedNumber) {
        return numbers.contains(pickedNumber);
    }
}
