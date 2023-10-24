package baseball.model;

import java.util.List;

public class Computer {
    private Numbers savedNumbers = new Numbers();
    private Hint hint = new Hint();

    public void saveNumbers(List<Integer> generatedNumbers) {
        this.savedNumbers = Numbers.from(generatedNumbers);
    }

    public String provideHint(Numbers inputNumbers) {
        hint.compareNumbers(savedNumbers, inputNumbers);
        return hint.generateHint();
    }

    public Boolean isCorrectAnswer() {
        return hint.hasThreeStrike();
    }
}
