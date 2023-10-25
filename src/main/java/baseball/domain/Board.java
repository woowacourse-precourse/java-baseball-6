package baseball.domain;

import java.util.Arrays;

public class Board {

    private static final int BOARD_SIZE = 3;
    public static final int INIT_SCORE = 0;

    private final int[] score;

    public Board() {
        score = new int[BOARD_SIZE];
    }

    public void reset() {
        Arrays.fill(score, INIT_SCORE);
    }

    public void addScore(BallStatus ball) {
        score[ball.getValue()]++;
    }

    public boolean isMatch(int matchScore) {
        return score[BallStatus.STRIKE.getValue()] == matchScore;
    }

    public int getScore(BallStatus status) {
        return score[status.getValue()];
    }
}
