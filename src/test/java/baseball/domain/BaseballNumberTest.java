package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseballNumberTest {

    @Test
    void 예외_테스트_길이가3이상() {
        List<Integer> invalidInput = List.of(1, 2, 3, 4);
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(invalidInput));
    }

    @Test
    void 예외_테스트_1미만숫자() {
        List<Integer> invalidInput = List.of(0, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(invalidInput));
    }

    @Test
    void 예외_테스트_9초과숫자() {
        List<Integer> invalidInput = List.of(1, 2, 10);
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(invalidInput));
    }

    @Test
    void 예외_테스트_중복된숫자() {
        List<Integer> invalidInput = List.of(1, 2, 2);
        assertThrows(IllegalArgumentException.class, () -> new BaseballNumber(invalidInput));
    }

    @Test
    void 볼_스트라이트_계산() {
        BaseballNumber number1 = new BaseballNumber(List.of(1, 2, 3));
        BaseballNumber number2 = new BaseballNumber(List.of(1, 3, 2));

        GameResultDTO result = number1.calculationGameResult(number2);

        assertEquals(2, result.getBall());
        assertEquals(1, result.getStrike());
    }
}

