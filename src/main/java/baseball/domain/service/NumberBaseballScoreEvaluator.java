package baseball.domain.service;

public class NumberBaseballScoreEvaluator {

    private final String targetNumber;
    private final String inputNumber;

    public NumberBaseballScoreEvaluator(String targetNumber, String inputNumber) {
        this.targetNumber = targetNumber;
        this.inputNumber = inputNumber;
    }

    private int countStrikes() {
        int strikes = 0;
        for (int i = 0; i < targetNumber.length(); i++) {
            if (targetNumber.charAt(i) == inputNumber.charAt(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private int countBalls() {
        int balls = 0;
        for (int i = 0; i < inputNumber.length(); i++) {
            char currentChar = inputNumber.charAt(i);
            if (targetNumber.indexOf(currentChar) != -1 && targetNumber.charAt(i) != currentChar) {
                balls++;
            }
        }
        return balls;
    }

    public String evaluate() {
        int strikes = countStrikes();
        int balls = countBalls();
        return formatResult(strikes, balls);
    }

    private String formatResult(int strikes, int balls) {
        StringBuilder result = new StringBuilder();

        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }

        if (balls > 0) {
            result.append(balls).append("볼");
        }

        if (strikes > 0 && balls > 0) {
            result.append(" ");
        }

        if (strikes > 0) {
            result.append(strikes).append("스트라이크");
        }

        return result.toString();
    }

}
