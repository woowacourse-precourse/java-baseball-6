package baseball;

import baseball.model.number.PlayNumber;
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

    @Test
    void 세자리_모두_정상이라면_문제없이_생성된다() {
        PlayNumber playNumber = PlayNumber.from("123");
    }
}
