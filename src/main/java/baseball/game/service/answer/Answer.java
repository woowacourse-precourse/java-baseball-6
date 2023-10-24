package baseball.game.service.answer;

public class Answer {

    private final AnswerState answerState;
    private final AnswerGenerator answerGenerator;

    public Answer(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
        this.answerState = new AnswerState(answerGenerator.generateBaseballNumbers(3));
    }

    public void regenerateAnswer() {
        String newAnswer = answerGenerator.generateBaseballNumbers(3);
        answerState.setAnswer(newAnswer);
    }

    public String getAnswer() {
        return answerState.getAnswer();
    }
}
