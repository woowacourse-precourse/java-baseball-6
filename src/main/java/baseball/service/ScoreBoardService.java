package baseball.service;

import baseball.domain.ScoreBoard;

import static baseball.domain.ScoreBoard.*;

public class ScoreBoardService {
    private final ScoreBoard scoreBoard;

    public ScoreBoardService(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public void updateScoreBoard(int balls, int strikes) {
        scoreBoard.setScoreBoard(balls, strikes);
    }

    public boolean isThreeStrike() {
        return scoreBoard.isThreeStrike();
    }

    public String generateGameResult() {
        if (scoreBoard.isNothing()) {
            return NOTHING;
        }
        if (scoreBoard.isOnlyBall()) {
            return scoreBoard.getBalls() + BALL;
        }
        if (scoreBoard.isOnlyStrike()) {
            return scoreBoard.getStrikes() + STRIKE;
        }

        return scoreBoard.toString();
    }

}
