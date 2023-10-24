package baseball.utils;

import java.util.List;

import baseball.domain.Result;

public class Caculator {

    public static Result count(final List<Integer> computer, final List<Integer> user) {
        Result result = new Result();

        result.setStrike(countStrike(computer, user));
        result.setBall(countBall(computer, user, result.getStrike()));

        return result;
    }

    private static int countStrike(final List<Integer> computer, final List<Integer> user) {
        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    private static int countBall(final List<Integer> computer, final List<Integer> user, final int strike) {
        int ball = 0;
        for (int i = 0; i < user.size(); i++) {
            if (computer.contains(user.get(i))) {
                ball += 1;
            }
        }
        return ball - strike;
    }
}
