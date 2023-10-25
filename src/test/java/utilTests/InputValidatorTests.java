package utilTests;

import baseball.container.ApplicationContainer;
import baseball.util.validator.InputValidator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputValidatorTests {
    private final ApplicationContainer container = new ApplicationContainer();
    private final InputValidator inputValidator = container.getInputValidator();

    @Test
    @DisplayName("자릿수 초과")
    void test1() {
        // given
        String input = "1234";

        // when
        boolean result = inputValidator.validate(input, input.length() - 1, 1, 9);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("자릿수 일치")
    void test2() {
        // given
        String input = "123";

        // when
        boolean result = inputValidator.validate(input, input.length(), 1, 9);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("정규표현식 일치")
    void test3() {
        // given
        String input = "1235";

        // when
        boolean result = inputValidator.validate(input, input.length(), 1, 9);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("정규표현식 불일치")
    void test4() {
        // given
        String input = "홍길동";

        // when
        boolean result = inputValidator.validate(input, input.length(), 1, 9);

        // then
        assertFalse(result);

    }


    @Test
    @DisplayName("중복값 입력")
    void test5() {
        // given
        String input = "111";

        // when
        boolean result = inputValidator.validate(input, input.length(), 1, 9, true);

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("고유값 입력")
    void test6() {
        // given
        String input = "198";

        // when
        boolean result = inputValidator.validate(input, input.length(), 1, 9, true);

        // then
        assertTrue(result);
    }
}
