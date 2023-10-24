package baseball;

import java.util.List;

public class Referee {
    private int strike;
    private int ball;

    public Integer countStrike(List<Integer> answer, List<Integer> playerInputIntegerList) {
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(playerInputIntegerList.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    public Integer countBall(List<Integer> answer, List<Integer> playerInputIntegerList) {
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
