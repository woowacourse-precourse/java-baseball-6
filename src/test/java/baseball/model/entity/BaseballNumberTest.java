package baseball.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import baseball.exception.BaseballException.NumberException;
import baseball.exception.BaseballException.NumberRangeException;
import org.junit.jupiter.api.Test;

class BaseballNumberTest {

    @Test
    public void 입력이_숫자가_아닌_경우_예외() {
        //given
        char input = 'a';

        //then
        assertThrows(NumberException.class, () -> new BaseballNumber(input));
    }

    @Test
    public void 입력이_범위를_초과한_경우_예외() {
        //given
        char input = '0';

        //then
        assertThrows(NumberRangeException.class, () -> new BaseballNumber(input));
    }
}