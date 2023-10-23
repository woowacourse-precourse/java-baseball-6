package baseball.global.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomBaseballNumberGeneratorTest {

    @DisplayName("자릿수에 맞게 서로 다른 난수 생성 후 리스트로 반환")
    @ParameterizedTest
    @ValueSource(ints = {2,3,4})
    void generateRandomBaseballNumberTest(int size){
        List<Integer> randomBaseballNumbers = RandomBaseballNumberGenerator.generateRandomBaseballNumbers(size);
        assertTrue(randomBaseballNumbers.stream()
                .distinct()
                .count() == randomBaseballNumbers.size());
    }
}