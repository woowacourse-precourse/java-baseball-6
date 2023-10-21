package baseball.service;

import baseball.domain.AnswerNumbers;
import baseball.domain.AttemptNumbers;
import baseball.repository.DomainRepository;
import baseball.utils.RandomNumberGenerator;

public class BaseballService {

    private final RandomNumberGenerator randomNumberGenerator;
    private final DomainRepository domainRepository;

    public BaseballService(
            final RandomNumberGenerator randomNumberGenerator,
            final DomainRepository domainRepository) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.domainRepository = domainRepository;
    }

    public void saveRandomNumbers() {
        final AnswerNumbers answerNumbers =
                new AnswerNumbers(randomNumberGenerator.generateNumbers());
        domainRepository.saveAnswerNumbers(answerNumbers);
    }

    public void checkAnswer(final AttemptNumbers attemptNumbers) {
        final AnswerNumbers answerNumbers = domainRepository.findAnswerNumbers();
    }
}
