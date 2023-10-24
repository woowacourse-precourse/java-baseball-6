package baseball.domain;

import java.util.List;

import static baseball.domain.GameSystem.NUMBER_LENGTH;

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
        return strikeCount == NUMBER_LENGTH;
    }

    public void calculateBaseBall(List<Integer> userNumbers, List<Integer> systemNumbers) {
        updateBall(userNumbers, systemNumbers);
        updateStrike(userNumbers, systemNumbers);
    }

    private void updateBall(List<Integer> userNumbers, List<Integer> systemNumbers) {
        int count = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (!userNumbers.get(i).equals(systemNumbers.get(i)) && systemNumbers.contains(userNumbers.get(i))) {
                count++;
            }
        }

        ballCount = count;
    }

    private void updateStrike(List<Integer> userNumbers, List<Integer> systemNumbers) {
        int count = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (userNumbers.get(i).equals(systemNumbers.get(i))) {
                count++;
            }
        }

        strikeCount = count;
    }


}
