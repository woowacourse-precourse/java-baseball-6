package baseball.model;

public class Referee {
    private static int OFFSET = 3;

    public int[] judgeGameScore(int[] userNumberArray, int[] computerNumberArray) {
        int[] score = {0, 0}; // ball, strike
        score[0] = countBall(userNumberArray, computerNumberArray);
        score[1] = countStrike(userNumberArray, computerNumberArray);
        return score;
    }

    public boolean judgeGameOver(int[] score) {
        if (score[1] == OFFSET) {
            return true;
        }
        return false;
    }

    private int countStrike(int[] userNumberArray, int[] computerNumberArray) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (userNumberArray[i] == computerNumberArray[j] && i == j) {
                    cnt++;

                }
            }
        }
        return cnt;
    }

    private int countBall(int[] userNumberArray, int[] computerNumberArray) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (userNumberArray[i] == computerNumberArray[j] && i != j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
