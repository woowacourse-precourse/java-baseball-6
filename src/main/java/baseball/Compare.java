package baseball;

import java.util.List;

public class Compare {

    public String result(List<Integer> computerNum, List<Integer> playerNum) {
        int strike = countStrike(computerNum, playerNum);
        int ball = countBall(computerNum, playerNum);
        int total = strike + ball;

        if (total == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼" + strike + "스트라이크";
    }

    public int countStrike(List<Integer> computerNum, List<Integer> playerNum) {
        int strike = 0;
        for (int i = 0; i < playerNum.size(); i++) {
            if (computerNum.get(i).equals(playerNum.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    public int countBall(List<Integer> computerNum, List<Integer> playerNum) {
        int ball = 0;
        for (int i = 0; i < playerNum.size(); i++) {
            if (computerNum.contains(playerNum.get(i)) && !computerNum.get(i).equals(playerNum.get(i))) {
                ball += 1;
            }
        }
        return ball;
    }
}
