package baseball.game.service;

public class Answer {

    private String answer;

    public Answer() {
        this(AnswerGenerator.generateBaseballNumbers());
    }

    public Answer(String initialAnswer) {
        this.answer = initialAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void regenerateAnswer() {
        this.answer = AnswerGenerator.generateBaseballNumbers();
    }
}
