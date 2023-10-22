package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

    @Nested
    @DisplayName("숫자 야구 게임의 숫자를 생성할 시")
    class construct {

        @DisplayName("1~9가 주어진다면 생성한다.")
        @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
        @ParameterizedTest(name = "입력: {0}")
        void success(int input) {
            //given
            //when
            BaseballNumber baseballNumber = new BaseballNumber(input);

            //then
            assertThat(baseballNumber.getNumber()).isEqualTo(input);
        }

        @DisplayName("1~9가 아니라면 예외를 발생시킨다.")
        @ValueSource(ints = {0, 10})
        @ParameterizedTest(name = "입력: {0}")
        void fail_InvalidRange(int input) {
            //given
            //when then
            assertThatThrownBy(() -> new BaseballNumber(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}