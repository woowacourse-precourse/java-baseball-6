package baseball;

import java.util.List;

public class Score {
    int ball;
    int strike;

    public void countScore(List<Integer> computer, List<Integer> player) {
        ball = 0;
        strike = 0;
        int[] scoreTable = new int[10];

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
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return strike + "스트라이크";
        }
        if (ball == 0) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
