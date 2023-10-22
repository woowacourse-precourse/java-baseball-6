package baseball.model;

import baseball.util.calculator.ScoreCalculator;
import baseball.util.generator.NumberGenerator;
import java.util.List;

public class Computer {

    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final ScoreCalculator scoreCalculator = new ScoreCalculator();

    public List<Integer> generateNumber() {
        return numberGenerator.getGeneratedNumbers();
    }

    public Score calculateScore(List<Integer> playerInput, List<Integer> answer) {
        return scoreCalculator.calculateScore(playerInput, answer);
    }
}
