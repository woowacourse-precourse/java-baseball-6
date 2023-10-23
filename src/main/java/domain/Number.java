package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final int num;
    public static final int numberCount = 3;

    private static final int minimumNumber = 1;
    private static final int maximumNumber = 9;
    private static final List<Integer> goalNumbers = new ArrayList<>(numberCount);

    static {
        setGoalNumbers();
    }

    public Number(int num) {
        this.num = num;
    }

    private static void setGoalNumbers() {
        goalNumbers.clear();
        for (int i = 0; i < numberCount; i++) {
            int randomNumber;
            do {
                randomNumber = Randoms.pickNumberInRange(minimumNumber, maximumNumber);
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
        for (int i = 0; i < numberCount; i++) {
            for (int j = 0; j < numberCount; j++) {
                if (numbers.get(i).num == goalNumbers.get(j)) {
                    if (i == j) {
                        strike++;
                    }
                    if (i != j) {
                        ball++;
                    }
                }
            }
        }
        return List.of(strike, ball);
    }

    // Test Method
    public static List<Integer> getGoalNumbers() {
        return goalNumbers;
    }
}
