package baseball.game;

public enum AnswerLength {
    ANSWER_LENGTH(3);

    private final int answerLength;

    AnswerLength(int answerLength) {
        this.answerLength = answerLength;
    }

    public int getAnswerLength() {
        return answerLength;
    }
}
