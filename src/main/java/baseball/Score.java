package baseball;

import java.util.List;

public class Score {
    private int strike;
    private int ball;
    private final String userNumbers;
    private final List<Integer> computerNumbers;

    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NONE = "낫싱";

    public Score(String userNumbers, List<Integer> computerNumbers) {
        this.strike = 0;
        this.ball = 0;
        this.userNumbers = userNumbers;
        this.computerNumbers = computerNumbers;
    }

    public String getUserNumbers() {
        return userNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void calculate() {
        for (int i = 0; i < computerNumbers.size(); i++) {
            int at = userNumbers.indexOf(String.valueOf(computerNumbers.get(i)));

            if (at == -1) {
                continue;
            }

            if (at == i) {
                addStrike();
            } else {
                addBall();
            }
        }
    }

    public String extractResult() {
        StringBuilder sb = new StringBuilder();

        if (ball > 0) {
            sb.append(ball).append(BALL);
        }

        if (ball > 0 && this.strike > 0) {
            sb.append(" ");
        }

        if (strike > 0) {
            sb.append(strike).append(STRIKE);
        }

        if (sb.isEmpty()) {
            sb.append(NONE);
        }

        return sb.toString();
    }
}
