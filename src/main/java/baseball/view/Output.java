package baseball.view;

import baseball.message.ConsoleMessage;

import java.util.List;

public class Output {

    public static void printCount(List<Integer> strikeBall) {
        int ball = strikeBall.get(0);
        int strike = strikeBall.get(1);

        StringBuilder result = new StringBuilder();


        checkNothing(strikeBall, result);
        checkBall(ball, result);
        checkStrike(strike, result);

        System.out.println(result);
        if (strike == 3) {
            System.out.println(ConsoleMessage.STRIKE_3.getMessage());
        }
    }

    private static void checkNothing(List<Integer> strikeBall, StringBuilder result) {
        if (strikeBall.get(0) == 0 && strikeBall.get(1) == 0) {
            result.append(ConsoleMessage.NOTHING.getMessage());
        }
    }

    private static void checkBall(int ball, StringBuilder result) {
        if (ball != 0) {
            result.append(ball);
            result.append(ConsoleMessage.BALL.getMessage());
        }
    }

    private static void checkStrike(int strike, StringBuilder result) {
        if (strike != 0) {
            result.append(strike);
            result.append(ConsoleMessage.STRIKE.getMessage());
        }
    }
}
