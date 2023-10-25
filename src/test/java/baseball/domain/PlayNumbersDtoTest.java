package baseball.domain;

import baseball.domain.player.dto.PlayerNumbersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayNumbersDtoTest {


    @DisplayName("PlayerNumbersDto에 input이 잘 들어가는지 확인")
    @Test
    void playerThreeNumbersTest() {
        String input = "123";
        PlayerNumbersDto playerNumbersDto = PlayerNumbersDto.of(input);

        assertThat(playerNumbersDto.playerNumbers())
                .isEqualTo(input);
    }

    @DisplayName("PlayerNumbersDto에 null 입력시 IllegalArgumentException 던지는지 확인")
    @Test
    void throwExceptionWhenInputNull() {
        String input = null;

        assertThatThrownBy(() -> PlayerNumbersDto.of(input))
                .isInstanceOf(NullPointerException.class);
    }

    @DisplayName("PlayerNumbersDto에 \"\" 입력시 IllegalArgumentException 던지는지 확인")
    @Test
    void throwExceptionWhenInputNothing() {
        String input = "";

        assertThatThrownBy(() -> PlayerNumbersDto.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("PlayerNumbersDto에 숫자 외 입력시 IllegalArgumentException 던지는지 확인")
    @Test
    void throwExceptionWhenInputNotNumbers() {
        String input = "12a";

        assertThatThrownBy(() -> PlayerNumbersDto.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("PlayerNumbersDto에 세글자 이상 입력시 IllegalArgumentException 던지는지 확인")
    @Test
    void throwExceptionWhenInputMoreThanThreeNumbers() {
        String input = "1234";

        assertThatThrownBy(() -> PlayerNumbersDto.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
