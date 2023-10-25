package baseball.domain;

public class Board {

    private static final int BOARD_SIZE = 3;

    private int[] score;

    public Board() {
    }

    public void reset() {
        score = new int[BOARD_SIZE];
    }

    public void scoring(BallStatus ball) {
        score[ball.getValue()]++;
    }

    public boolean isMatch(int matchCount) {
        return score[BallStatus.STRIKE.getValue()] == matchCount;
    }

    public int getScore(BallStatus status) {
        return score[status.getValue()];
    }
}
