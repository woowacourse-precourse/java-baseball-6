package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.model.input.RestartOrExitInput;
import org.junit.jupiter.api.Test;

class RestartOrExitInputTest {

    @Test
    void validate_정상입력() {
        // given
        String input1 = "1";
        String input2 = "2";

        // when
        RestartOrExitInput restartOrExitInput1 = new RestartOrExitInput(input1);
        RestartOrExitInput restartOrExitInput2 = new RestartOrExitInput(input2);

        // then
    }

    @Test
    void validate_다른_길이_입력() {
        // given
        String input = "11";

        // when

        // then
        assertThatThrownBy(() -> new RestartOrExitInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력이 1자리가 아닙니다.");
    }


    @Test
    void validate_다른_문자_입력() {
        // given
        String input = "X";

        // when

        // then
        assertThatThrownBy(() -> new RestartOrExitInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2의 입력이 아닙니다.");
    }

    @Test
    void isExitInput_재시작() {
        // given
        String input = "1";

        // when
        RestartOrExitInput restartOrExitInput = new RestartOrExitInput(input);

        // then
        assertThat(restartOrExitInput.isExitInput()).isEqualTo(false);
    }

    @Test
    void isExitInput_종료() {
        // given
        String input = "2";

        // when
        RestartOrExitInput restartOrExitInput = new RestartOrExitInput(input);

        // then
        assertThat(restartOrExitInput.isExitInput()).isEqualTo(true);
    }
}
