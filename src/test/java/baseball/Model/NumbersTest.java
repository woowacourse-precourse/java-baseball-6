package baseball.Model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumbersTest {


    @Test
    void 숫자세게아닐시예외발생() {
        List<Integer> inputNumbers = Arrays.asList(1, 2);
        assertThrows(IllegalArgumentException.class, () -> new Numbers(inputNumbers));
    }

    @Test
    void 중복된숫자확인시예외발생() {
        List<Integer> inputNumbers = Arrays.asList(1, 2, 2);
        assertThrows(IllegalArgumentException.class, () -> new Numbers(inputNumbers));
    }
}
