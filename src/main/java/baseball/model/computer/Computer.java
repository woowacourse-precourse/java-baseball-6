package baseball.model.computer;

import java.util.List;

public class Computer {

    private GameAnswer gameAnswer;
    private Score score;

    public Computer() {
        this.gameAnswer = new GameAnswer();
        this.score = new Score();
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

    public boolean isScoreAllStrike() {
        return score.isAllStrike();
    }

    public void initScore() {
        score.initScore();
    }
}
