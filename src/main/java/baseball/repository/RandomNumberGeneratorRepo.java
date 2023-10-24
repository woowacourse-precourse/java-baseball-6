package baseball.repository;

import baseball.domain.Game;
import baseball.domain.RandomNumberGenerator;

public class RandomNumberGeneratorRepo {

    private static RandomNumberGenerator randomNumberGenerator;

    public static void save(RandomNumberGenerator randomNumberGenerator) {
        RandomNumberGeneratorRepo.randomNumberGenerator = randomNumberGenerator;
    }

    public static RandomNumberGenerator find() {
        return RandomNumberGeneratorRepo.randomNumberGenerator;
    }
}
