package baseball.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("사용자_입력_테스트")
class ValidatorTest {
    @Test
    void 정해진_개수의_숫자를_입력하라() {
        //given
        String input = "4241";
        int size = 3;

        //when
        Validator validator = new Validator();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkValid(input, size));

        assertEquals("올바른 자리 수의 값을 입력하세요.", exception.getMessage());
    }

    @Test
    void 정해진_범위의_정수를_입력하라() {
        //given
        String inputWithString = "1a2";
        String inputWithZero = "102";
        int size = 3;

        //when
        Validator validator = new Validator();

        //then
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> validator.checkValid(inputWithString, size));

        assertEquals("1부터 9까지의 수를 입력하세요.", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> validator.checkValid(inputWithZero, size));

        assertEquals("1부터 9까지의 수를 입력하세요.", exception2.getMessage());
    }

    @Test
    void 중복되지_않은_숫자를_입력하라() {
        //given
        String input = "112";
        int size = 3;

        //when
        Validator validator = new Validator();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkValid(input, size));

        assertEquals("중복된 숫자를 포함하고 있습니다.", exception.getMessage());
    }

    @Test
    void RETRY_또는_EXIT_중에서_입력하라() {
        //given
        String input = "3";
        String RETRY = "1";
        String EXIT = "2";

        //when
        Validator validator = new Validator();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.checkValid(input, RETRY, EXIT));

        assertEquals("1(재시작)과 2(종료) 중 하나의 수를 입력하세요.", exception.getMessage());
    }

}
