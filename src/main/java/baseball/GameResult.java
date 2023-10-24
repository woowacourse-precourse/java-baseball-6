package baseball;

import java.util.List;

public class GameResult {
    public String score(List<Integer> computer, List<Integer> userNumber) {
        Compare compare = new Compare();

        int total = compare.countTotal(computer, userNumber);
        int strike = compare.countStrike(computer, userNumber);

        int ball = total - strike;

        String score;

        if (total == 0) { // 일치하는 수가 없는 경우
            score = "낫싱";
        } else if (ball == 0) { // 볼은 없지만 스트라이크만 존재하는 경우
            score = strike + "스트라이크";
            System.out.println("게임 종료");
            System.out.println("1볼 1스트라이크");
        } else if (strike == 0) {
            score = ball + "볼";
        } else {
            score = ball + "볼 " + strike + "스트라이크";

        }
        return score;
    }
}

