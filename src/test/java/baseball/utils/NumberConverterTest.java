package baseball.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.domain.BaseballMessageConst;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumberConverterTest {

    @Test
    void String을_List_로_변경한다() {
        String input = "123";
        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> result = NumberConverter.stringToNumber(input);
        assertEquals(expected, result);
    }

    @Test
    void 숫자_형태의_문자가_아니먄_IllegalArgumentException() {
        String input = "12a";
        assertThrows(IllegalArgumentException.class, () -> NumberConverter.stringToNumber(input),
                BaseballMessageConst.INVALID_BALL_TYPE);
    }

}