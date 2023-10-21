package baseball.util;

import java.util.List;

public class NumericComparator {
    private int strikeCount;
    private int ballCount;

    public void resetCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public void compare(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        resetCount();

        for (int i = 0; i < 3; i++) {
            int playerNumber = playerNumbers.get(i);
            int computerNumber = computerNumbers.get(i);

            // 같은 위치에 있는 원소가 똑같을 때 -> 스트라이크 ++
            if (playerNumber == computerNumber) {
                strikeCount++;
                // 같은 위치에 없고, 리스트에 존재는 할 때 -> 볼++
            } else if (computerNumbers.contains(playerNumber)) {
                ballCount++;
            }
        }
    }
}
