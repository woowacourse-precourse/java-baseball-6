package baseball.utils;

public class CompareUtils {
    public boolean isaBall(int[] gameNumber, int[] userNumber, int i, int j) {
        return gameNumber[i] == userNumber[j] && i != j;
    }

    public boolean isaStrike(int[] gameNumber, int[] userNumber, int i, int j) {
        return gameNumber[i] == userNumber[j] && i == j;
    }
}
