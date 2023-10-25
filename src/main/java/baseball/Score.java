package baseball;

import java.util.List;

public class Score {
    private final static int NOTHING = 0;
    private final static int LENGTH_OF_TABLE = 10;

    int ball;
    int strike;

    Score(List<Integer> computer, List<Integer> player) {
        ball = NOTHING;
        strike = NOTHING;
        int[] scoreTable = new int[LENGTH_OF_TABLE];

        for (int digit : computer) {
            scoreTable[digit] = computer.indexOf(digit);
        }
        for (int digit : player) {
            if (!computer.contains(digit)) {
                continue;
            }
            if (scoreTable[digit] == player.indexOf(digit)) {
                strike++;
                continue;
            }
            ball++;
        }
    }

    public String printScore() {
        if (strike == NOTHING && ball == NOTHING) {
            return "낫싱";
        }
        if (ball == NOTHING) {
            return strike + "스트라이크";
        }
        if (strike == NOTHING) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
