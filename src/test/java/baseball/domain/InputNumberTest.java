package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputNumberTest {

    private InputNumber inputNumber;

    @Test
    @DisplayName("입력값에 0이 있으면 예외 발생")
    void shouldThrowExceptionWhenInputContainsZero() {
        assertThrows(IllegalArgumentException.class, () -> InputNumber.create(List.of(0, 2, 6)));
        assertThrows(IllegalArgumentException.class, () -> InputNumber.create(List.of(1, 0, 3)));
        assertThrows(IllegalArgumentException.class, () -> InputNumber.create(List.of(1, 2, 0)));
        assertThrows(IllegalArgumentException.class, () -> InputNumber.create(List.of(1, 0, 0)));
        assertThrows(IllegalArgumentException.class, () -> InputNumber.create(List.of(0, 0, 0)));
    }

    @Test
    @DisplayName("입력값이 중복이 존재하면 예외 발생")
    void shouldThrowExceptionWhenDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> InputNumber.create(List.of(1, 1, 1)));
        assertThrows(IllegalArgumentException.class, () -> InputNumber.create(List.of(1, 2, 2)));
        assertThrows(IllegalArgumentException.class, () -> InputNumber.create(List.of(1, 2, 1)));
    }

    @Test
    @DisplayName("입력값의 길이가 설정값을 넘으면 예외 발생")
    void shouldThrowExceptionWhenNumberLengthOver() {
        assertThrows(IllegalArgumentException.class, () -> InputNumber.create(List.of(1, 2, 3, 4)));
        assertThrows(IllegalArgumentException.class, () -> InputNumber.create(List.of(1, 2)));
        assertThrows(IllegalArgumentException.class, () -> InputNumber.create(List.of(1)));
    }

    @Test
    @DisplayName("가져오는 Index에 맞게 숫자를 제대로 가져오는지 검증")
    void getNumberAtIndexTest() {
        inputNumber = InputNumber.create(List.of(1, 2, 3));
        Assertions.assertThat(inputNumber.getNumberAtIndex(0)).isEqualTo(1);
    }
}
