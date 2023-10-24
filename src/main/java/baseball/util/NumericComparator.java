package baseball.util;

import java.util.List;

public class NumericComparator {
    private static final int BALL_NUMBER_LENGTH = 3;
    private int strikeCount;
    private int ballCount;

    public void resetCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void compare(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        resetCount();

        for (int i = 0; i < BALL_NUMBER_LENGTH; i++) {
            int playerNumber = playerNumbers.get(i);
            int computerNumber = computerNumbers.get(i);

            // 같은 위치에 있는 원소가 똑같을 때 -> 스트라이크 ++
            if (isStrike(playerNumber, computerNumber)) {
                strikeCount++;
                // 같은 위치에 없고, 리스트에 존재는 할 때 함-> 볼++
            } else if (isBall(playerNumber, computerNumbers)) {
                ballCount++;
            }
        }
    }

    private boolean isStrike(int playerNumber, int computerNumber) {
        return playerNumber == computerNumber;
    }

    private boolean isBall(int playerNumber, List<Integer> computerNumbers) {
        return computerNumbers.contains(playerNumber);
    }
}
