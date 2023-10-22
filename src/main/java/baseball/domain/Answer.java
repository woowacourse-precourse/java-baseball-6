package baseball.domain;


public class Answer {
    private final BaseballNumbers numbers;

    public Answer(BaseballNumbers answer) {
        this.numbers = answer;
    }

    public Score match(BaseballNumbers inputBaseballNumbers) {
        return numbers.calculateScore(inputBaseballNumbers);
    }
}
