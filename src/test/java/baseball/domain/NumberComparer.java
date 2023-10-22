package baseball.domain;

import java.util.List;

public class NumberComparer {
    private int strikeCount;
    private int ballCount;

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void compareNumbers(String playerNumbers, List<Integer> coputerNumbers) {
        strikeCount = 0;
        ballCount = 0;

        for (int i=0; i<playerNumbers.length(); i++) {
            int playerNumber = playerNumbers.charAt(i) - 48;
            int computerNumber = coputerNumbers.get(i);

            if (playerNumber == computerNumber) {
                strikeCount += 1;
            } else if (playerNumber != computerNumber && coputerNumbers.contains(playerNumber)) {
                ballCount += 1;
            }
        }
    }
}
