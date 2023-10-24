package baseball;

import baseball.model.number.PlayNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayNumberTest {

    @Test
    void 플레이_숫자는_세자리여야만_한다() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayNumber playNumber = PlayNumber.from("1234");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo("길이는 3이어야 합니다.");
    }

    @Test
    void 플레이_숫자는_숫자여야만_한다() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayNumber playNumber = PlayNumber.from("12a");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo("1 ~ 9 사이의 값이어야만 합니다.");
    }

    @Test
    void 플레이_숫자는_중복되면_안된다() {
        // given & when
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayNumber playNumber = PlayNumber.from("111");
        });
        // then
        assertThat(exception.getMessage()).isEqualTo("숫자들이 중복되면 안 됩니다.");
    }

    @Test
    void 세자리_모두_정상이라면_문제없이_생성된다() {
        PlayNumber playNumber = PlayNumber.from("123");
    }
}
