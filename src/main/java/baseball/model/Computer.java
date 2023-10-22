package baseball.model;

import baseball.util.NumberGenerator;
import baseball.util.ScoreCalculator;
import java.util.List;

public class Computer {

    private NumberGenerator numberGenerator = new NumberGenerator();
    private ScoreCalculator scoreCalculator = new ScoreCalculator();

    public List<Integer> getGeneratedNumber() {
        return numberGenerator.getGeneratedNumbers();
    }
}
