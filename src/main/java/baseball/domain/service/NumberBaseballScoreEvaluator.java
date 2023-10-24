package baseball.domain.service;

import baseball.domain.model.ScoreMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NumberBaseballScoreEvaluator {


    private int countStrikes(String inputNumber, String targetNumber) {
        int strikes = 0;
        for (int i = 0; i < targetNumber.length(); i++) {
            if (targetNumber.charAt(i) == inputNumber.charAt(i)) {
                strikes++;
            }
        }
        return strikes;
    }


    private static boolean isBall(String inputNumber, String targetNumber, int i) {
        return targetNumber.indexOf(inputNumber.charAt(i)) != -1
                && targetNumber.charAt(i) != inputNumber.charAt(i);
    }

    private int countBalls(String inputNumber, String targetNumber) {
        return (int) IntStream.range(0, inputNumber.length())
                .filter(i -> isBall(inputNumber, targetNumber, i))
                .count();
    }

    public String evaluate(String inputNumber, String targetNumber) {
        int strikes = countStrikes(inputNumber, targetNumber);
        int balls = countBalls(inputNumber, targetNumber);
        return formatResult(strikes, balls);
    }

    private String formatResult(int strikes, int balls) {
        if (isNoHit(strikes, balls)) {
            return ScoreMessage.NOTHING.formatMessage(0);
        }

        List<String> messages = new ArrayList<>();

        if (balls > 0) {
            messages.add(ScoreMessage.BALL.formatMessage(balls));
        }

        if (strikes > 0) {
            messages.add(ScoreMessage.STRIKE.formatMessage(strikes));
        }

        return String.join(" ", messages);
    }

    private boolean isNoHit(int strikes, int balls) {
        return strikes == 0 && balls == 0;
    }


}
