package baseball.game;

import static baseball.util.RandomNumbersGenerator.getRandomNumbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersGeneratorTest {

    @Test
    @DisplayName("중복없는 랜덤한 수 생성 테스트")
    void getRandomNumbersTest() {
        // given
        String randomNumbers = getRandomNumbers();
        System.out.println("randomNumbers = " + randomNumbers);
    }
}