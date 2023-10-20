package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersGeneratorTest {

    @Test
    @DisplayName("중복없는 랜덤한 수 생성 테스트")
    void getRandomNumbers() {
        // given
        String randomNumbers = RandomNumbersGenerator.getRandomNumbers();
        System.out.println("randomNumbers = " + randomNumbers);
    }
}