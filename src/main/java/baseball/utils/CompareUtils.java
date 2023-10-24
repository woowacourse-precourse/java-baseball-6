package baseball.utils;

import baseball.domain.Game;

public class CompareUtils {
    public boolean isaBall(int[] gameNumber, int[] userNumber, int i, int j) {
        return gameNumber[i] == userNumber[j] && i != j;
    }

    public boolean isaStrike(int[] gameNumber, int[] userNumber, int i, int j) {
        return gameNumber[i] == userNumber[j] && i == j;
    }

    public void validateResult(int[] gameNumber, int[] userNumber, int i, int j, Game game) {
        if (isaStrike(gameNumber, userNumber, i, j)) {
            game.strikeCount();
        }
        if (isaBall(gameNumber, userNumber, i, j)) {
            game.ballCount();
        }
    }
}
