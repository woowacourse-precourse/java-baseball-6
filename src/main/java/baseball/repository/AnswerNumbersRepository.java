package baseball.repository;

import baseball.domain.AnswerNumbers;

public class AnswerNumbersRepository {

    private AnswerNumbers answerNumbers;

    public void saveAnswerNumbers(final AnswerNumbers numbers) {
        this.answerNumbers = numbers;
    }

    public AnswerNumbers findAnswerNumbers() {
        return this.answerNumbers;
    }
}
