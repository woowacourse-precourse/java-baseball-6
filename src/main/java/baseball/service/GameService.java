package baseball.service;

import baseball.model.GameHint;

import java.util.List;

public class GameService {

    public int[] getGameResult(List<Integer> randomNumbers, int[] playersNumbers) {
        return checkGameResultOf(randomNumbers, playersNumbers);
    }

    public boolean isThreeStrike(int[] gameResult) {
        final int threeStrike = 3;
        return gameResult[GameHint.STRIKE.getResultIndex()] == threeStrike;
    }

    private int[] checkGameResultOf(List<Integer> randomNumbers, int[] playersNumbers) {
        final int threeDigit = 3;

        int strikeCount = 0;
        int ballCount = 0;
        int nothingCount = 0;
        int[] gameResult = new int[threeDigit];

        for (int i = 0; i < 3; i++) {
            if (randomNumbers.get(i).equals(playersNumbers[i])) {
                gameResult[GameHint.STRIKE.getResultIndex()] = ++strikeCount;
                continue;
            }
            if (randomNumbers.contains(playersNumbers[i])) {
                gameResult[GameHint.BALL.getResultIndex()] = ++ballCount;
            }
        }
        if (gameResult[GameHint.STRIKE.getResultIndex()] + gameResult[GameHint.BALL.getResultIndex()] == 0) {
            gameResult[GameHint.BALL.getResultIndex()] = ++nothingCount;
        }

        return gameResult;
    }
}
