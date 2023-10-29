package racingcar.domain.numbergenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {
    NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    @Test
    void 랜덤_숫자_생성_테스트() {

        for(int i = 0; i < 100; i++) {
            int randomNumber = randomNumberGenerator.generate();

            assertThat(randomNumber).isBetween(0, 9);
        }
    }
}
