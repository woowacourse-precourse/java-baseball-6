package baseball.game.service.answer;

public class AnswerState {

    private String answer;

    public AnswerState(String initialAnswer) {
        this.answer = initialAnswer;
    }

    String getAnswer() {
        return answer;
    }

    void setAnswer(String answer) {
        this.answer = answer;
    }
}
