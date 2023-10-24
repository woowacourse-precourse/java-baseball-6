package baseball.application;

import baseball.domain.Number;
import baseball.domain.Numbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NumberGeneratorTest {

    private final NumberGenerator testNumberGenerator =
            () -> new Numbers(List.of(new Number(1), new Number(2), new Number(3)));

    @Test
    public void 상대편의_숫자를_생성한다() {

        Numbers numbers = testNumberGenerator.generateNumbers();
        Assertions.assertTrue(numbers.hasNumber(new Number(1)));
        Assertions.assertTrue(numbers.hasNumber(new Number(2)));
        Assertions.assertTrue(numbers.hasNumber(new Number(3)));
    }
}
