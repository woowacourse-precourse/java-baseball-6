package baseball.domain;


public class Computer {
    private final Answer answer;

    public Computer(AnswerGenerator answerGenerator) {
        answer = answerGenerator.generate();
    }

    public Score getScore(String input) {
        return answer.match(input);
    }
}
