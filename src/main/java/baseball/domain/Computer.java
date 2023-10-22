package baseball.domain;


public class Computer {
    private final Answer answer;

    public Computer(NumbersGenerator answerGenerator) {
        answer = new Answer(answerGenerator.generate());
    }

    public Score getScore(String input) {
        return answer.match(input);
    }
}
