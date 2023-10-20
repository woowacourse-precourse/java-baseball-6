package baseball.domain;

import java.util.List;

public class Hint {
    private int ballCount;
    private int strikeCount;

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isWin() {
        return strikeCount == 3;
    }

    public void calculateBaseBall(List<Integer> userNumbers, List<Integer> systemNumbers) {
        updateBall(userNumbers, systemNumbers);
        updateStrike(userNumbers, systemNumbers);
    }

    private void updateBall(List<Integer> userNumbers, List<Integer> systemNumbers) {
        int count = 0;

        for (int i = 0; i < 3; i++)
            if (userNumbers.get(i) != systemNumbers.get(i) && systemNumbers.contains(userNumbers.get(i)))
                count++;

        ballCount = count;
    }

    private void updateStrike(List<Integer> userNumbers, List<Integer> systemNumbers) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i) == systemNumbers.get(i))
                count++;
        }

        strikeCount = count;
    }


}
