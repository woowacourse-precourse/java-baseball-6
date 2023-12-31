package baseball.model;

import static baseball.model.Option.GAME_OVER;
import static baseball.model.Option.GAME_START;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionTest {

    @Test
    void 옵션_불러오기_테스트() {
        int input = 1;

        Assertions.assertThat(Option.getOptionByNumber(input))
                .isEqualTo(GAME_START);
    }

    @Test
    void 옵션_불러오기_테스트2() {
        int input = 2;

        Assertions.assertThat(Option.getOptionByNumber(input))
                .isEqualTo(GAME_OVER);
    }

    @Test
    void 없는_옵션_입력_시_예외발생() {
        int input = 3;

        Assertions.assertThatThrownBy(() -> Option.getOptionByNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
