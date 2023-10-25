package baseball.repository;

import baseball.domain.RandomNumberGenerator;

public class RandomNumberGaneratorRepository {
    private static RandomNumberGenerator randomNumberGenerator;

    public static void save(RandomNumberGenerator randomNumberGenerator){
        RandomNumberGaneratorRepository.randomNumberGenerator = randomNumberGenerator;
    }

    public static RandomNumberGenerator find(){
        return RandomNumberGaneratorRepository.randomNumberGenerator;
    }
}