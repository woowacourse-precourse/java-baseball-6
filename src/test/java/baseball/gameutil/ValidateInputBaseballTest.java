package baseball.gameutil;

import baseball.message.ErrorMessage;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class ValidateInputBaseballTest {

    @Test
    void 게임중_세_자리_미만_문자열() {
        //given
        String input = "13";
        ValidateInputBaseball validateInputBaseBall = new ValidateInputBaseball();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputBaseBall.validateGameInput(input);
            }
        );

        //then
        String expected = ErrorMessage.gameLenError;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_네_자리_이상_문자열() {
        //given
        String input = "0123";
        ValidateInputBaseball validateInputBaseBall = new ValidateInputBaseball();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputBaseBall.validateGameInput(input);
            }
        );

        //then
        String expected = ErrorMessage.gameLenError;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_금지된_문자열_존재() {
        //given
        String input = "1a3";
        ValidateInputBaseball validateInputBaseBall = new ValidateInputBaseball();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputBaseBall.validateGameInput(input);
            }
        );

        //then
        String expected = ErrorMessage.wrongGameInputError;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_제로가_포함된_경우() {
        String input = "103";
        ValidateInputBaseball validateInputBaseBall = new ValidateInputBaseball();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputBaseBall.validateGameInput(input);
            }
        );

        //then
        String expected = ErrorMessage.wrongGameInputError;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_올바른_문자열이_온_경우() {
        String input = "123";
        ValidateInputBaseball validateInputBaseBall = new ValidateInputBaseball();

        //when
        String ret = validateInputBaseBall.validateGameInput(input);

        //then
        Assertions.assertEquals(ret, input);
    }

    @Test
    void 게임재게_두_자리_이상_문자열() {
        //given
        String input = "02";
        ValidateInputBaseball validateInputBaseBall = new ValidateInputBaseball();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputBaseBall.validateRerunInput(input);
            }
        );

        //then
        String expected = ErrorMessage.wrongRerunInputError;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임재게_금지된_문자열_존재() {
        //given
        String input = "A";
        ValidateInputBaseball validateInputBaseBall = new ValidateInputBaseball();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputBaseBall.validateRerunInput(input);
            }
        );

        //then
        String expected = ErrorMessage.wrongRerunInputError;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임재게_다른숫자가_들어온_경우() {
        String input = "0";
        ValidateInputBaseball validateInputBaseBall = new ValidateInputBaseball();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputBaseBall.validateRerunInput(input);
            }
        );

        //then
        String expected = ErrorMessage.wrongRerunInputError;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임재게_숫자가_온_경우() {
        String input = "1";
        ValidateInputBaseball validateInputBaseBall = new ValidateInputBaseball();

        //when
        String ret = validateInputBaseBall.validateRerunInput(input);

        //then
        Assertions.assertEquals(ret, input);
    }
}
