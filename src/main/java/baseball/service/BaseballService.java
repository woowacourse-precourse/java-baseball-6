package baseball.service;

import baseball.domain.Numbers;
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
        final Numbers numbers = new Numbers(randomNumberGenerator.generateNumbers());
        domainRepository.saveAnswerNumbers(numbers);
    }
}
