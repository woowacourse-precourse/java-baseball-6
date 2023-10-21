package baseball.domain;


public class Computer {
    private Answer answer;

    public Computer(AnswerGenerator answerGenerator) {
        initAnswer(answerGenerator);
    }

    public void initAnswer(AnswerGenerator answerGenerator) {
        answer = answerGenerator.generate();
    }

    public Score getScore(String input) {
        return answer.match(input);
    }
}
