package baseball.game;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConverterTest {
    private Converter converter;

    @BeforeEach
    void init() {
        converter = new Converter();
    }

    @Test
    void 입력한_문자열을_숫자리스트로_변함() {
        Assertions.assertEquals(List.of(1, 2, 3), converter.convertToInputNumbers("123"));
        Assertions.assertEquals(List.of(9, 3, 2), converter.convertToInputNumbers("932"));
        Assertions.assertEquals(List.of(7, 2, 3), converter.convertToInputNumbers("723"));
    }

    @Test
    void 문자를_입력했을때_에러발생() {
        Assertions.assertThrows(NumberFormatException.class, () -> converter.convertToInputNumbers("abc"));
    }
}