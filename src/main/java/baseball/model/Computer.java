package baseball.model;

public class Computer {
    private Numbers savedNumbers = new Numbers();
    private Hint hint = new Hint();

    public Computer() {
    }

    public Computer(Numbers generatedNumbers) {
        this.savedNumbers = generatedNumbers;
    }

    public static Computer from(Numbers generatedNumbers) {
        return new Computer(generatedNumbers);
    }

    public String provideHint(Numbers inputNumbers) {
        hint.compareNumbers(savedNumbers, inputNumbers);
        return hint.generateHint();
    }

    public Boolean isCorrectAnswer() {
        return hint.hasThreeStrike();
    }
}
