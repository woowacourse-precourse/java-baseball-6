package baseball.domain;

import baseball.utils.Converter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallListTest {

    @Test
    void _3자리_입력만_가능합니다() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new BallList(Converter.extractDigitsFromNumber(1234))
        );
    }

    @Test
    void 서로다른_숫자_입력만_가능합니다() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new BallList(Converter.extractDigitsFromNumber(112))
        );
    }

    @Test
    void _1부터_9까지의_숫자만_입력_가능합니다() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new BallList(Converter.extractDigitsFromNumber(102))
        );
    }
}
