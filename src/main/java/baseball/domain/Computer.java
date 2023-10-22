package baseball.domain;


public class Computer {
    private final Answer answer;

    public Computer(BaseballNumbersGenerator answerGenerator) {
        answer = new Answer(answerGenerator.generate());
    }

    public Score getScore(BaseballNumbers inputBaseballNumbers) {
        return answer.match(inputBaseballNumbers);
    }
}
