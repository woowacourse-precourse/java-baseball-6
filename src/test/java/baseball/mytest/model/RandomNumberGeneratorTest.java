package baseball.mytest.model;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    RandomNumberGenerator generator = new RandomNumberGenerator();

    @Test
    void 랜덤_숫자_생성_출력_확인() {
        System.out.println(generator.generateRandomNumber());
    }
}
