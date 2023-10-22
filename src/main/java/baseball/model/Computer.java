package baseball.model;

import baseball.util.NumberGenerator;
import baseball.util.ScoreCalculator;
import java.util.List;

public class Computer {

    private List<Integer> answer;
    private Score score;

    public void generateNumber() {
        NumberGenerator numberGenerator = new NumberGenerator();
        this.answer = numberGenerator.getGeneratedNumbers();
    }

    public void generateScore(List<Integer> playerInput) {
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        this.score = scoreCalculator.calculateScore(playerInput, getAnswer());
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public Score getScore() {
        return score;
    }
}
