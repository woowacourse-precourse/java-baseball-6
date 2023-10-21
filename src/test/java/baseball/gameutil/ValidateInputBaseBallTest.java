package baseball.gameutil;

import baseball.message.ErrorMessage;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class ValidateInputBaseBallTest {
    // 4자리 문자열이 온 경우
    // 3자리 중에서 한 개라도 금지된 문자열이 존재
    // 3자리 문자열 중에서 0이 포함된 경우
    // 1~9 가 모두 무사하게 온 경우

    @Test
    void 네_자리_이상_문자열() {
        //given
        String input = "0123";
        ValidateInputBaseBall validateInputBaseBall = new ValidateInputBaseBall();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputBaseBall.validateGameInput(input);
            }
        );

        //then
        String expected = ErrorMessage.lenError;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 금지된_문자열_존재() {
        //given
        String input = "1a3";
        ValidateInputBaseBall validateInputBaseBall = new ValidateInputBaseBall();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputBaseBall.validateGameInput(input);
            }
        );

        //then
        String expected = ErrorMessage.wrongInputError;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 제로가_포함된_경우() {
        String input = "103";
        ValidateInputBaseBall validateInputBaseBall = new ValidateInputBaseBall();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputBaseBall.validateGameInput(input);
            }
        );

        //then
        String expected = ErrorMessage.wrongInputError;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 올바른_문자열이_온_경우() {
        String input = "123";
        ValidateInputBaseBall validateInputBaseBall = new ValidateInputBaseBall();

        //when
        String ret = validateInputBaseBall.validateGameInput(input);

        //then
        Assertions.assertEquals(ret, input);
    }

}
