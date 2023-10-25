package baseball.global.util;

import baseball.domain.BaseballNumber;
import baseball.domain.RandomBaseballNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomBaseballNumberGeneratorTest {

    @DisplayName("자릿수에 맞게 서로 다른 난수 생성 후 리스트로 반환")
    @ParameterizedTest
    @ValueSource(ints = {2,3,4})
    void generateRandomBaseballNumberTest(int size){
        BaseballNumber randomBaseballNumbers = RandomBaseballNumberGenerator.generateRandomBaseballNumber(size);
        List<Integer> unWrappedBaseballNumber = unWrapBaseballNumber(randomBaseballNumbers);
        assertTrue(unWrappedBaseballNumber.stream()
                .distinct()
                .count() == unWrappedBaseballNumber.size());
    }

    private List<Integer> unWrapBaseballNumber(BaseballNumber baseballNumber){
        int size = baseballNumber.getSize();
        List<Integer> unWrappedBaseballNumber = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            unWrappedBaseballNumber.add(baseballNumber.getSize());
        }
        return unWrappedBaseballNumber;
    }
}