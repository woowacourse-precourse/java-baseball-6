package baseball.service;

import baseball.model.CompareResult;

public class NumberChecker {

    public static CompareResult compare(String computerNumber, String playerNumber) {
        Integer ball = countBall(computerNumber, playerNumber);
        Integer strike = countStrike(computerNumber, playerNumber);
        return new CompareResult(ball, strike);
    }

    private static Integer countBall(String computerNumber, String playerNumber) {
        Integer ball = 0;
        for (int i = 0; i < playerNumber.length(); i++) {
            char c = playerNumber.charAt(i);
            if (computerNumber.contains(String.valueOf(c)) && computerNumber.charAt(i) != playerNumber.charAt(i)) {
                ball++;
            }
        }
        return ball;
    }

    private static Integer countStrike(String computerNumber, String playerNumber) {
        Integer strike = 0;
        for (int i = 0; i < playerNumber.length(); i++) {
            if (computerNumber.charAt(i) == playerNumber.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }
}
