package baseball.service;

import baseball.domain.AnswerNumbers;
import baseball.domain.AttemptNumbers;
import baseball.domain.BallCount;
import baseball.repository.AnswerNumbersRepository;
import baseball.utils.RandomNumberGenerator;

public class BaseballService {

    private final RandomNumberGenerator randomNumberGenerator;
    private final AnswerNumbersRepository answerNumbersRepository;

    public BaseballService(
            final RandomNumberGenerator randomNumberGenerator,
            final AnswerNumbersRepository answerNumbersRepository) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.answerNumbersRepository = answerNumbersRepository;
    }

    public void saveRandomNumbers() {
        final AnswerNumbers answerNumbers =
                new AnswerNumbers(randomNumberGenerator.generateNumbers());
        answerNumbersRepository.saveAnswerNumbers(answerNumbers);
    }

    public BallCount checkAnswer(final AttemptNumbers attemptNumbers) {
        final AnswerNumbers answerNumbers = answerNumbersRepository.findAnswerNumbers();
        return attemptNumbers.checkAnswer(answerNumbers);
    }
}
