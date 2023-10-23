package baseball.domain;

import baseball.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Baseball 클래스 테스트")
class BaseballTest {

    @Test
    @DisplayName("올바른 숫자 리스트를 통과하는 테스트")
    void testValidNumbers() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3);
        Baseball.validateNumbers(validNumbers);
    }

    @Test
    @DisplayName("잘못된 길이의 숫자 리스트를 통과하지 못하는 테스트")
    void testInvalidLengthNumbers() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2);
        assertThrows(InvalidInputException.class, () -> Baseball.validateNumbers(invalidNumbers));
    }

    @Test
    @DisplayName("중복된 숫자를 포함하는 숫자 리스트를 통과하지 못하는 테스트")
    void testDuplicateNumbers() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 2);
        assertThrows(InvalidInputException.class, () -> Baseball.validateNumbers(duplicateNumbers));
    }

    @Test
    @DisplayName("범위를 벗어난 숫자를 포함하는 숫자 리스트를 통과하지 못하는 테스트")
    void testOutOfRangeNumbers() {
        List<Integer> outOfRangeNumbers = Arrays.asList(0, 1, 2);
        assertThrows(InvalidInputException.class, () -> Baseball.validateNumbers(outOfRangeNumbers));
    }
}
