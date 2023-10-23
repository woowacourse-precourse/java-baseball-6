package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final int num;
    public static final int NUMBER_COUNT = 3;

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;
    private static final List<Integer> goalNumbers = new ArrayList<>(NUMBER_COUNT);

    public Number(int num) {
        this.num = num;
    }

    public static void reset() {
        resetGoalNumbers();
    }

    private static void resetGoalNumbers() {
        goalNumbers.clear();
        for (int i = 0; i < NUMBER_COUNT; i++) {
            int randomNumber;
            do {
                randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
            } while (goalNumbers.contains(randomNumber));
            goalNumbers.add(randomNumber);
        }
    }

    public static int getStrike(List<Number> numbers) {
        return getScore(numbers).get(0);
    }

    public static int getBall(List<Number> numbers) {
        return getScore(numbers).get(1);
    }

    private static List<Integer> getScore(List<Number> numbers) {
        int strike = 0, ball = 0;
        for (int i = 0; i < NUMBER_COUNT; i++) {
            if (isStrike(numbers, i)) {
                strike++;
            }
            if (isBall(numbers, i)){
                ball++;
            }
        }
        return List.of(strike, ball);
    }

    private static boolean isStrike(List<Number> numbers, int idx) {
        return goalNumbers.get(idx) == numbers.get(idx).num;
    }

    private static boolean isBall(List<Number> numbers, int idx) {
        if (goalNumbers.contains(numbers.get(idx).num)) {
            return goalNumbers.get(idx) != numbers.get(idx).num;
        }
        return false;
    }

    // Test Method
    public static List<Integer> getGoalNumbers() {
        return goalNumbers;
    }
}
