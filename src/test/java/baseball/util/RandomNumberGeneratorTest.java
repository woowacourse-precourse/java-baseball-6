package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    private static final int NUMBER_LENGTH = 3;

    @Test
    void 중복된_수가_존재하는지_테스트_01() {
        List<Integer> randomNumberList = RandomNumberGenerator.generateRandomNumberList();

        boolean result = hasDuplicateDigits(randomNumberList);

        assertThat(result).isFalse();
    }

    @Test
    void 중복된_수가_존재하는지_테스트_02() {
        List<Integer> randomNumberList = RandomNumberGenerator.generateRandomNumberList();

        boolean result = hasDuplicateDigits(randomNumberList);

        assertThat(result).isFalse();
    }

    @Test
    void 중복된_수가_존재하는지_테스트_03() {
        List<Integer> randomNumberList = RandomNumberGenerator.generateRandomNumberList();

        boolean result = hasDuplicateDigits(randomNumberList);

        assertThat(result).isFalse();
    }

    @Test
    void 중복된_수가_존재하는지_테스트_04() {
        List<Integer> randomNumberList = RandomNumberGenerator.generateRandomNumberList();

        boolean result = hasDuplicateDigits(randomNumberList);

        assertThat(result).isFalse();
    }

    @Test
    void 중복된_수가_존재하는지_테스트_05() {
        List<Integer> randomNumberList = RandomNumberGenerator.generateRandomNumberList();

        boolean result = hasDuplicateDigits(randomNumberList);

        assertThat(result).isFalse();
    }

    @Test
    void 중복된_수가_존재하는지_테스트_06() {
        List<Integer> randomNumberList = RandomNumberGenerator.generateRandomNumberList();

        boolean result = hasDuplicateDigits(randomNumberList);

        assertThat(result).isFalse();
    }

    @Test
    void 중복된_수가_존재하는지_테스트_07() {
        List<Integer> randomNumberList = RandomNumberGenerator.generateRandomNumberList();

        boolean result = hasDuplicateDigits(randomNumberList);

        assertThat(result).isFalse();
    }

    @Test
    void 중복된_수가_존재하는지_테스트_08() {
        List<Integer> randomNumberList = RandomNumberGenerator.generateRandomNumberList();

        boolean result = hasDuplicateDigits(randomNumberList);

        assertThat(result).isFalse();
    }

    @Test
    void 중복된_수가_존재하는지_테스트_09() {
        List<Integer> randomNumberList = RandomNumberGenerator.generateRandomNumberList();

        boolean result = hasDuplicateDigits(randomNumberList);

        assertThat(result).isFalse();
    }

    @Test
    void 중복된_수가_존재하는지_테스트_10() {
        List<Integer> randomNumberList = RandomNumberGenerator.generateRandomNumberList();

        boolean result = hasDuplicateDigits(randomNumberList);

        assertThat(result).isFalse();
    }

    private static boolean hasDuplicateDigits(List<Integer> numbers) {
        for (int i = 0; i < NUMBER_LENGTH - 1; i++) {
            for (int j = i + 1; j < NUMBER_LENGTH; j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

}