package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PlayerValidator 클래스")
class PlayerValidatorTest {

    @Test
    void 숫자가_세_자리_수가_아니면_예외_발생() {
        List<Integer> numbers = Arrays.asList(1, 2);
        assertThrows(IllegalArgumentException.class, () -> PlayerValidator.validate(numbers));
    }

    @Test
    void 숫자가_세_자리_수일_경우_예외_발생하지_않음() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertDoesNotThrow(() -> PlayerValidator.validate(numbers));
    }

    @Test
    void 중복된_수가_있으면_예외_발생() {
        List<Integer> numbers = Arrays.asList(2, 6, 6); // 2가 중복됩니다.
        assertThrows(IllegalArgumentException.class, () -> PlayerValidator.validate(numbers));
    }

    @Test
    void 범위를_벗어난_수가_있으면_예외_발생(){
        List<Integer> numbers = Arrays.asList(0, 2, 3); // 0은 범위 외의 숫자입니다.
        assertThrows(IllegalArgumentException.class, () -> PlayerValidator.validate(numbers));
    }
}