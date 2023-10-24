package baseball.dto.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReplayDtoTest {

    @Nested
    @DisplayName("입력 받은 게임 재시작 여부의 유효성 검증 시")
    class construct {

        @DisplayName("1이나 2라면 ReplayDto를 생성한다.")
        @ValueSource(strings = {"1", "2"})
        @ParameterizedTest(name = "입력: {0}")
        void success(String input) {
            //given
            //when
            ReplayDto replayDto = new ReplayDto(input);

            //then
            assertThat(replayDto.replay()).isEqualTo(input);
        }

        @DisplayName("1이나 2가 아니라면 예외를 발생시킨다.")
        @ValueSource(strings = {"0", "3", " ", "", "\n\n"})
        @ParameterizedTest(name = "입력: {0}")
        void fail_InvalidCharacter(String input) {
            //given
            //when then
            assertThatThrownBy(() -> new ReplayDto(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}