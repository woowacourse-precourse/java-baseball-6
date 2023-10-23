package baseball.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TypeConvertorTest {

    @Test
    @DisplayName("String으로 받은 숫자 문자열을 타입 변환하면 List로 만든다.")
    void stringToIntegerList() {
        List<Integer> integers = TypeConvertor.stringToIntegerList("123");
        Assertions.assertThat(integers)
                .contains(1, 2, 3)
                .doesNotContain(4, 5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a2", "1*2", "aaksdanl", "테스트", "   "})
    @DisplayName("문자열에 숫자가 아닌 다른 값이 들어오면 에러가 발생한다.")
    void shouldThrowExceptionWhenIsNotNumber(String input) {
        assertThrows(IllegalArgumentException.class, () -> TypeConvertor.stringToIntegerList(input));
    }
}