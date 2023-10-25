package baseball.service;

import java.util.List;

public class GameService {

    public int[] getGameResult(List<Integer> randomNumbers, int[] playersNumbers) {
        return checkGameResultOf(randomNumbers, playersNumbers);
    }

    public boolean isThreeStrike(int[] gameResult) {
        final int threeStrike = 3;
        return gameResult[0] == threeStrike;
    }

    private int[] checkGameResultOf(List<Integer> randomNumbers, int[] playersNumbers) {
        int strike = 0;
        int ball = 0;
        int nothing = 0;
        int[] gameResult = new int[3];

        for (int i = 0; i < 3; i++) {
            if (randomNumbers.get(i).equals(playersNumbers[i])) {
                gameResult[0] = ++strike;
                continue;
            }
            if (randomNumbers.contains(playersNumbers[i])) {
                gameResult[1] = ++ball;
            }
        }
        if (gameResult[0] + gameResult[1] == 0) {
            gameResult[2] = ++nothing;
        }

        return gameResult;
    }
}
