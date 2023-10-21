package baseball.repository;

import baseball.domain.Numbers;

public class DomainRepository {

    private Numbers answerNumbers;

    public void saveAnswerNumbers(final Numbers numbers) {
        this.answerNumbers = numbers;
    }
}
