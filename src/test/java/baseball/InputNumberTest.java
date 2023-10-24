package baseball;

import baseball.exception.InputException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumberTest {
    @Test
    void 사용자_유효한_숫자_입력() {
        List<Integer> input = List.of(1, 2, 3);
        assertThat(input.size()).isEqualTo(3);
    }

    @Test
    void 사용자_길이_오류_숫자_입력() {
        String input = "1";
        assertThatThrownBy(() -> InputException.lengthException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3글자가 아닙니다.");
    }

    @Test
    void 사용자_중복된_숫자_입력() {
        String input = "122";
        assertThatThrownBy(() -> InputException.duplicateException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 있습니다.");
    }

    @Test
    void 사용자_문자포함_숫자_입력() {
        String input = "S2!";
        assertThatThrownBy(() -> InputException.notNumericException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @Test
    void 사용자_범위를_벗어난_숫자_입력_테스트() {
        String input = "109";
        assertThatThrownBy(() -> InputException.outOfRangeException(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1~9의 범위를 벗어난 숫자가 있습니다.");
    }
}
