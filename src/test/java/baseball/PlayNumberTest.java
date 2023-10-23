package baseball;

import baseball.model.PlayNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayNumberTest {

    @Test
    void 플레이_숫자는_세자리여야만_한다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayNumber playNumber = PlayNumber.from("1234");
        });
    }

    @Test
    void 플레이_숫자는_숫자여야만_한다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayNumber playNumber = PlayNumber.from("12a");
        });
    }

    @Test
    void 플레이_숫자는_중복되면_안된다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayNumber playNumber = PlayNumber.from("111");
        });
    }
}
