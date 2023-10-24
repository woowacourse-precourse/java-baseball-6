package baseball.model.numberstrategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserInputNumberSelectionStrategyTest {

    @Test
    void 입력값은_숫자만_가능하다() {
        //given
        String inputNumber = "1bc";

        //when & then
        Assertions.assertThatThrownBy(() -> new UserInputNumberSelectionStrategy(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력이 가능합니다.");
    }

    @Test
    void 중복_된_숫자는_입력할_수_없다() {
        //given
        String inputNumber = "112";

        //when & then
        Assertions.assertThatThrownBy(() -> new UserInputNumberSelectionStrategy(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복 된 숫자는 입력할 수 없습니다.");
    }

    @Test
    void 세_자리의_숫자만_입력_가능하다() {
        //given
        String inputNumber = "1234";

        //when & then
        Assertions.assertThatThrownBy(() -> new UserInputNumberSelectionStrategy(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("세 자리의 숫자만 입력이 가능합니다.");
    }

    @Test
    void 숫자는_1과_9사이만_입력_가능하다() {
        //given
        String inputNumber = "032";

        //when & then
        Assertions.assertThatThrownBy(() -> new UserInputNumberSelectionStrategy(inputNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 9 사이의 숫자만 입력이 가능합니다.");
    }
}