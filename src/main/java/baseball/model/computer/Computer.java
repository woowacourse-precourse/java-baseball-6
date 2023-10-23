package baseball.model.computer;

import java.util.List;

public class Computer {

    private static final Integer INIT_STRIKE_SCORE = 0;
    private static final Integer INIT_BALL_SCORE = 0;

    private GameAnswer gameAnswer;
    private Score score;

    public Computer() {
        this.gameAnswer = new GameAnswer();
        this.score = new Score(INIT_STRIKE_SCORE, INIT_BALL_SCORE);
    }

    public void makeAnswer() {
        gameAnswer.makeAnswer();
    }

    public List<Integer> getGameAnswer() {
        return gameAnswer.getAnswer();
    }

    public void calculateScore(List<Integer> playerInput) {
        score.calculateScore(playerInput, getGameAnswer());
    }

    public Score getScore() {
        return score;
    }
}
