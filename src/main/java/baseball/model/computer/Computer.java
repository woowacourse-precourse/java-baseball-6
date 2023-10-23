package baseball.model.computer;

import baseball.model.Score;
import java.util.List;

public class Computer {

    private GameAnswer gameAnswer;
    private ScoreCalculator scoreCalculator;

    public Computer() {
        this.gameAnswer = new GameAnswer();
        this.scoreCalculator = new ScoreCalculator();
    }

    public void makeAnswer() {
        gameAnswer.makeAnswer();
    }
    
    public List<Integer> getGameAnswer() {
        return gameAnswer.getAnswer();
    }

    public Score getScore(List<Integer> playerInput, List<Integer> answer) {
        return scoreCalculator.calculateScore(playerInput, answer);
    }
}
