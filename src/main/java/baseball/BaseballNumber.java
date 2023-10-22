package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballNumber {

    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int INITIAL_VALUE = 0;
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final int ANSWER = 3;
    private static int ball = INITIAL_VALUE;
    private static int strike = INITIAL_VALUE;

    public static List<Integer> generateComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < BaseballNumber.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(BaseballNumber.MIN_NUMBER, BaseballNumber.MAX_NUMBER);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public static List<Integer> generatePlayerNumber(String inputNumber) {
        validatePlayerNumber(inputNumber);
        return inputNumber.chars()
                .map(e -> e - '0')
                .boxed()
                .toList();
    }

    private static void validatePlayerNumber(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("INVALID NUMBER LENGTH");
        }
        Set<Integer> playerNumber = inputNumber.chars()
                .map(e -> e - '0')
                .boxed()
                .collect(Collectors.toSet());
        if (playerNumber.size() < NUMBER_LENGTH) {
            throw new IllegalArgumentException("DUPLICATE NUMBER");
        }
        if (playerNumber.stream().anyMatch(e -> e < 1 || e > 9)) {
            throw new IllegalArgumentException("INVALID NUMBER");
        }
    }

    public static String getResult(List<Integer> computerNumber, List<Integer> playerNumber) {
        initialBallAndStrike();
        countBallAndStrike(computerNumber, playerNumber);
        if (isNothing()) {
            return NOTHING;
        }
        if (isOnlyBall()) {
            return ball + BALL;
        }
        if (isOnlyStike()) {
            return strike + STRIKE;
        }
        return ball + BALL + " " + strike + STRIKE;
    }

    private static void initialBallAndStrike() {
        ball = INITIAL_VALUE;
        strike = INITIAL_VALUE;
    }

    private static void countBallAndStrike(List<Integer> computerNumber, List<Integer> playerNumber) {
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (isStrike(computerNumber, playerNumber, index)) {
                strike++;
                continue;
            }
            if (isBall(computerNumber, playerNumber, index)) {
                ball++;
            }
        }
    }

    private static boolean isStrike(List<Integer> computerNumber, List<Integer> playerNumber, int index) {
        return computerNumber.get(index).equals(playerNumber.get(index));
    }

    private static boolean isBall(List<Integer> computerNumber, List<Integer> playerNumber, int index) {
        return computerNumber.contains(playerNumber.get(index));
    }

    private static boolean isNothing() {
        return ball == INITIAL_VALUE && strike == INITIAL_VALUE;
    }

    private static boolean isOnlyBall() {
        return strike == INITIAL_VALUE;
    }

    private static boolean isOnlyStike() {
        return ball == INITIAL_VALUE;
    }

    public static int getStrike() {
        return strike;
    }

    public static int getAnswer() {
        return ANSWER;
    }
}
