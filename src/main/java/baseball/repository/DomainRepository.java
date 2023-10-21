package baseball.repository;

import baseball.domain.AnswerNumbers;

public class DomainRepository {

    private AnswerNumbers answerNumbers;

    public void saveAnswerNumbers(final AnswerNumbers answerNumbers) {
        this.answerNumbers = answerNumbers;
    }
}
