package baseball.domain.service;

import baseball.domain.model.ScoreMessage;

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

    private int countBalls(String inputNumber, String targetNumber) {
        int balls = 0;
        for (int i = 0; i < inputNumber.length(); i++) {
            char currentChar = inputNumber.charAt(i);
            if (targetNumber.indexOf(currentChar) != -1 && targetNumber.charAt(i) != currentChar) {
                balls++;
            }
        }
        return balls;
    }

    public String evaluate(String inputNumber, String targetNumber) {
        int strikes = countStrikes(inputNumber, targetNumber);
        int balls = countBalls(inputNumber, targetNumber);
        return formatResult(strikes, balls);
    }

    private String formatResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return ScoreMessage.NOTHING.formatMessage(0);
        }

        StringBuilder result = new StringBuilder();

        if (balls > 0) {
            result.append(ScoreMessage.BALL.formatMessage(balls));
        }

        if (strikes > 0) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(ScoreMessage.STRIKE.formatMessage(strikes));
        }

        return result.toString();
    }


}
