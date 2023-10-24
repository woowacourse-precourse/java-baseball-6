package baseball;

import java.util.List;

public class Referee {
    private int strike;

    public Integer countStrike(List<Integer> answer, List<Integer> playerInputIntegerList) {
        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(playerInputIntegerList.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }
}
