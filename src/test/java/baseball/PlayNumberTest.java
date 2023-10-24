package baseball;

import baseball.model.number.PlayNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static baseball.ExceptionMessage.PLAY_NUMBER_DUPLICATE_EXCEPTION;
import static baseball.ExceptionMessage.PLAY_NUMBER_LENGTH_EXCEPTION;
import static baseball.ExceptionMessage.PLAY_NUMBER_VALUE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayNumberTest {

    @Test
    void 플레이_숫자는_세자리여야만_한다() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayNumber playNumber = PlayNumber.from("1234");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(PLAY_NUMBER_LENGTH_EXCEPTION.toString());
    }

    @Test
    void 플레이_숫자는_숫자여야만_한다() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayNumber playNumber = PlayNumber.from("12a");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(PLAY_NUMBER_VALUE_EXCEPTION.toString());
    }

    @Test
    void 플레이_숫자는_중복되면_안된다() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayNumber playNumber = PlayNumber.from("111");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo(PLAY_NUMBER_DUPLICATE_EXCEPTION.toString());
    }

    @Test
    void 세자리_모두_정상이라면_문제없이_생성된다() {
        PlayNumber playNumber = PlayNumber.from("123");
    }
}
