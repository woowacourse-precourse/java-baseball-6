package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.model.input.NumberInput;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumberInputTest {

    @Test
    void validate_정상적인_경우() {
        // given
        String input = "123";

        // when
        NumberInput numberInput = new NumberInput(input);

        // then
    }

    @Test
    void validate_3자리가_아닌_경우() {
        // given
        String input = "1234";

        // when

        // then
        assertThatThrownBy(() -> new NumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 3자리가 아닙니다.");
    }

    @Test
    void validate_숫자가_아닌_문자가_있는_경우() {
        // given
        String input = "a12";

        // when

        // then
        assertThatThrownBy(() -> new NumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 문자가 입력되었습니다.");
    }

    @Test
    void validate_0이_섞여있는_경우() {
        // given
        String input = "120";

        // when

        // then
        assertThatThrownBy(() -> new NumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 문자가 입력되었습니다.");
    }

    @Test
    void validate_중복된_수가_있는_경우() {
        // given
        String input = "122";

        // when

        // then
        assertThatThrownBy(() -> new NumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 입력되었습니다.");
    }

    @Test
    void parseInputToIntegerList_정상적인_경우() {
        // given
        String input = "123";
        NumberInput numberInput = new NumberInput(input);

        // when
        List<Integer> list = numberInput.parseInputToIntegerList();

        // then
        assertThat(list).isEqualTo(List.of(1, 2, 3));
    }

}
