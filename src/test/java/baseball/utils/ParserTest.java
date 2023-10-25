package baseball.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {
    @Test
    public void 문자열을_숫자_리스트로_변환한다() {
        List<Integer> result = Parser.parseNumbers("123");
        List<Integer> expected = List.of(1, 2, 3);
        assertEquals(expected, result);
    }

    @Test
    public void 문자열을_숫자로_변환한다() {
        Integer result = Parser.parseRestartOrExit("1");
        Integer expected = 1;
        assertEquals(expected, result);
    }
}