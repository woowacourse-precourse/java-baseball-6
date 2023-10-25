package baseball.domain;

import baseball.common.exception.input.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {
    @Test
    @DisplayName("크기가 3이 아닌 경우 예외가 발생한다.")
    public void 크키가_3이_아닌_경우() throws Exception {
        List<Integer> numberList = List.of(1, 2, 3, 4);

        assertThrows(InputException.class, () -> {
            new Numbers(numberList);
        });
    }

    @Test
    @DisplayName("중복 숫자가 있으면 예외가 발생한다.")
    public void 중복이_있는_경우() throws Exception {
        List<Integer> numberList = List.of(1, 2, 2);

        assertThrows(InputException.class, () -> {
            new Numbers(numberList);
        });
    }

    @Test
    @DisplayName("숫자가 1 ~ 9 사이가 아니면 예외가 발생한다.")
    public void 숫자가_범위를_벗어난_경우() throws Exception {
        List<Integer> numberList = List.of(1, 2, 10);

        assertThrows(InputException.class, () -> {
            new Numbers(numberList);
        });
    }
}