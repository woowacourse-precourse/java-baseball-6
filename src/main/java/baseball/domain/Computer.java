package baseball.domain;


public class Computer {
    private final BaseballNumbers numbers;

    public Computer(BaseballNumbersGenerator answerGenerator) {
        numbers = answerGenerator.generate();
    }

    public Score calculateScore(BaseballNumbers inputBaseballNumbers) {
        return numbers.calculateScore(inputBaseballNumbers);
    }
}
