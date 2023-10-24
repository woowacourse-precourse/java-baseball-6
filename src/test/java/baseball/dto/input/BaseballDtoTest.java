package baseball.dto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballDtoTest {

    @Nested
    @DisplayName("입력 받은 숫자 야구의 유효성 검증 시")
    class construct {

        @DisplayName("검증에 성공하면 BaseballDto를 생성한다.")
        @ValueSource(strings = {"123", "987", "385", "564"})
        @ParameterizedTest(name = "입력: {0}")
        void success(String input) {
            //given
            //when
            BaseballDto baseballDto = new BaseballDto(input);

            //then
            assertThat(baseballDto.baseball()).isEqualTo(input);
        }

        @DisplayName("1~9까지 숫자가 아니라면 예외를 발생시킨다.")
        @ValueSource(strings = {"012", "4~3", "1 3", "34\n", "", "\n\n\n"})
        @ParameterizedTest(name = "입력: {0}")
        void fail_InvalidCharacter(String input) {
            //given
            //when then
            assertThatThrownBy(() -> new BaseballDto(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("중복된 숫자가 있다면 예외를 발생시킨다.")
        @ValueSource(strings = {"221", "122", "212", "333"})
        @ParameterizedTest(name = "입력: {0}")
        void fail_Duplicated(String input) {
            //given
            //when then
            assertThatThrownBy(() -> new BaseballDto(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}