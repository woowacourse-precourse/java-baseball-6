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
    void 입력한_문자열을_숫자리스트로_변환해야_함() {
        Assertions.assertEquals(List.of(1, 2, 3), converter.convertToInputNumbers("123"));
        Assertions.assertEquals(List.of(9, 3, 2), converter.convertToInputNumbers("932"));
        Assertions.assertEquals(List.of(7, 2, 3), converter.convertToInputNumbers("723"));
    }

    @Test
    void 숫자로_구성된_입력이_아닐_때_에러발생해야_함() {
        Assertions.assertThrows(NumberFormatException.class, () -> converter.convertToInputNumbers("abc"));
        Assertions.assertThrows(NumberFormatException.class, () -> converter.convertToInputNumbers("  "));
        Assertions.assertThrows(NumberFormatException.class, () -> converter.convertToInputNumbers("0_0"));
    }
}