package baseball.model;

import java.util.List;
import java.util.Objects;

public class CompareNumbers {
    private int ball;
    private int strike;

    public int[] getNumberCompareResult(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        resetCount();
        ballCount(computerNumbers, playerNumbers);
        strikeCount(computerNumbers, playerNumbers);

        return new int[]{ball, strike};
    }

    public void resetCount() {
        ball = 0;
        strike = 0;
    }

    public int ballCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            int playNumber = playerNumbers.get(i);
            int computerNumberIndex = computerNumbers.indexOf(playNumber);
            if (computerNumberIndex != -1 && computerNumberIndex != i) {
                ball++;
            }
        }
        return ball;
    }

    public int strikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (Objects.equals(computerNumbers.get(i), playerNumbers.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public int getStrike(){
        return strike;
    }
}
