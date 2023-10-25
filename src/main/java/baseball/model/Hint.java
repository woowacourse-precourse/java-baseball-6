package baseball.model;

import java.util.List;

public class Hint {

    private static final int GAME_NUMBER_LENGTH = 3;

    public Hint() {}

    public int getBallCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ballCount = 0;

        for(int i = 0; i < GAME_NUMBER_LENGTH; i++) {
            int playerNumber = playerNumbers.get(i);

            if (!computerNumbers.get(i).equals(playerNumber) && computerNumbers.contains(playerNumber)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    public int getStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = 0;

        for(int i = 0; i < GAME_NUMBER_LENGTH; i++) {
            if(computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }
}
