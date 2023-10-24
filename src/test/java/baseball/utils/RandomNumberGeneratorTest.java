package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @DisplayName("랜덤 숫자 개수 테스트")
    @Test
    void randomNumberSizeTest() {
        RandomNumberGenerator generator = RandomNumberGenerator.getInstance();
        int minNum = 1;
        int maxNum = 9;
        int size = 5;
        List<Integer> uniqueRandomNumbers = generator.makeUniQueRandomNumbers(minNum, maxNum, size);
        assertThat(uniqueRandomNumbers.size())
                .isEqualTo(size);
    }

    @DisplayName("랜덤 숫자 범위 테스트")
    @Test
    void randomNumberRangeTest() {
        RandomNumberGenerator generator = RandomNumberGenerator.getInstance();
        int minNum = 1;
        int maxNum = 9;
        int size = 3;
        List<Integer> uniqueRandomNumbers = generator.makeUniQueRandomNumbers(minNum, maxNum, size);
        assertThat(
                uniqueRandomNumbers.stream()
                        .allMatch(n -> n >= minNum && n <= maxNum)
        )
                .isTrue();
    }

    @DisplayName("랜덤 숫자 유일값 테스트")
    @Test
    void randomNumberUniqueTest() {
        RandomNumberGenerator generator = RandomNumberGenerator.getInstance();
        int minNum = 1;
        int maxNum = 9;
        int size = 7;

        List<Integer> uniqueRandomNumbers = generator.makeUniQueRandomNumbers(minNum, maxNum, size);
        Set<Integer> numberSet = Set.copyOf(uniqueRandomNumbers);
        assertThat(numberSet.size())
                .isEqualTo(size);
    }
}