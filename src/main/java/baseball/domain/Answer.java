package baseball.domain;


public class Answer {
    private final Numbers numbers;

    public Answer(Numbers answer) {
        this.numbers = answer;
    }

    public Score match(String input) {
        return numbers.calculateScore(input);
    }
}
