package baseball.model.computer;

import baseball.model.Score;
import java.util.List;

public class Computer {

    private final NumberGenerator numberGenerator;
    private final ScoreCalculator scoreCalculator;

    public Computer() {
        this.numberGenerator = new NumberGenerator();
        this.scoreCalculator = new ScoreCalculator();
    }

    public List<Integer> generateNumber() {
        return numberGenerator.getGeneratedNumbers();
    }

    public Score getScore(List<Integer> playerInput, List<Integer> answer) {
        return scoreCalculator.calculateScore(playerInput, answer);
    }
}
