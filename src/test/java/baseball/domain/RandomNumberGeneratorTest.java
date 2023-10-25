package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤한 숫자를 생성할 수 있다")
    void generateTest() {
        RandomNumberGenerator generator = createRandomNumberGenerator(List.of(3, 6, 9, 7, 2, 1));
        assertDoesNotThrow(generator::generate);
    }

    @Test
    @DisplayName("중간에 중복된 수를 제공하더라도 랜덤한 숫자를 생성할 수 있다")
    void generateTest_whenSuppliedOverlappedValue() {
        RandomNumberGenerator generator = createRandomNumberGenerator(List.of(3, 6, 3, 6, 7));
        assertDoesNotThrow(generator::generate);
    }

    RandomNumberGenerator createRandomNumberGenerator(List<Integer> mockData) {
        return new RandomNumberGenerator(new MockIntegerSupplier(mockData));
    }

    private class MockIntegerSupplier implements Supplier<Integer> {

        private final List<Integer> data;
        private int currentIndex = 0;

        MockIntegerSupplier(List<Integer> data) {
            this.data = data;
        }

        @Override
        public Integer get() {
            return data.get(currentIndex++);
        }
    }
}
