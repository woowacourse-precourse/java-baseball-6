package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputMapperTest {

    @DisplayName("각 문자열은 숫자여야 한다.")
    @Test
    void checkNumberFormat() {
        assertThatThrownBy(() -> InputMapper.mapToInteger(List.of("1", "2", "a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }

    @DisplayName("알 수 없는 문자열(null) 포함되어 있는 경우, 변환할 수 없다.")
    @Test
    void checkIncludeNull() {
        List<String> input = new ArrayList<>();
        input.add(null);
        input.add("1");
        input.add("3");

        assertThatThrownBy(() -> InputMapper.mapToInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }

    @DisplayName("빈 문자열이 포함되어 있는 경우, 변환할 수 없다.")
    @Test
    void checkEmptyString() {
        assertThatThrownBy(() -> InputMapper.mapToInteger(List.of("  ", "2", "3")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }

    @DisplayName("알 수 없는 입력값(null)은 변환할 수 없다.")
    @Test
    void checkNull() {
        assertThatThrownBy(() -> InputMapper.mapToInteger(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알 수 없는 입력값(null)입니다.");
    }

    @DisplayName("사용자 입력을 숫자로 변환한다.")
    @Test
    void mapToInt() {
        int result = InputMapper.mapToInt("3");

        assertThat(result).isEqualTo(3);
    }
}
