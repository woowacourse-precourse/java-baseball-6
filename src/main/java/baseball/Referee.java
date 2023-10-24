package baseball;

import java.util.List;

public class Referee {
    public String judge(List<Integer> answer, List<Integer> playerInputIntegerList) {
        int totalStrike = countStrike(answer, playerInputIntegerList);
        int totalBall = countBall(answer, playerInputIntegerList);
        String judgement;
        if (totalStrike == 0 && totalBall == 0) {
            judgement = "낫싱";
        } else if (totalStrike == 3) {
            judgement = String.format("%d스트라이크", totalStrike);
        } else if (totalStrike == 0) {
            judgement = String.format("%d볼", totalBall);
        } else if (totalBall == 0) {
            judgement = String.format("%d스트라이크", totalStrike);
        } else {
            judgement = String.format("%d볼 %d스트라이크", totalBall, totalStrike);
        }
        return judgement;
    }

    public Integer countStrike(List<Integer> answer, List<Integer> playerInputIntegerList) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(playerInputIntegerList.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    public Integer countBall(List<Integer> answer, List<Integer> playerInputIntegerList) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answer.get(i).equals(playerInputIntegerList.get(i)) && (i != j)) {
                    ball += 1;
                }
            }
        }
        return ball;
    }
}
