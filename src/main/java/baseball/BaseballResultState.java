package baseball;

import java.util.List;

public class BaseballResultState {
    public int ball;
    public int strike;

    public BaseballResultState(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isGameOver() {
        return strike == BaseballGame.ANSWER_LENGTH;
    }

    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return String.format("%d볼", ball);
        }
        if (ball == 0) {
            return String.format("%d스트라이크", strike);
        }
        return String.format("%d볼 %d스트라이크", ball, strike);
    }

    static public BaseballResultState match(List<Integer> a, List<Integer> b) {
        int ball = 0, strike = 0;

        for (int i = 0; i < BaseballGame.ANSWER_LENGTH; i++) {
            for (int j = 0; j < BaseballGame.ANSWER_LENGTH; j++) {
                if (!a.get(i).equals(b.get(j))) {
                    continue;
                }

                if (i == j) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        return new BaseballResultState(ball, strike);
    }
}
