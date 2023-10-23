package baseball.domain;

import java.util.List;
import java.util.Objects;

public class AnswerChecker {

    private AnswerChecker() {
    }

    public static String result(final List<Integer> computer, final List<Integer> user) {

        int strike = isStrike(computer, user);
        int ball = isBall(computer, user);
        String result = "";

        if (ball != 0) {
            result = String.format("%d볼 ", ball);
        }
        if (strike != 0) {
            result += String.format("%d스트라이크", strike);
        }
        if (Objects.equals(result, "")) {
            return Hint.nothing();
        }
        return result;
    }

    private static int isBall(final List<Integer> computer, final List<Integer> user) {
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            ball += ballCounter(computer, user.get(i), i);
        }
        return ball;
    }

    private static int ballCounter(final List<Integer> computer, final int userItem, final int i) {
        if (!computer.contains(userItem)) {
            return 0;
        }
        if (i != computer.indexOf(userItem)) {
            return 1;
        }
        return 0;
    }

    private static int isStrike(final List<Integer> computer, final List<Integer> user) {
        int strike = 0;

        for (int i = 0; i < computer.size(); i++) {
            strike += strikeCounter(computer, user.get(i), i);
        }
        return strike;
    }

    private static int strikeCounter(final List<Integer> computer, final int userItem, final int i) {

        if (i == computer.indexOf(userItem)) {
            return 1;
        }
        return 0;
    }
}