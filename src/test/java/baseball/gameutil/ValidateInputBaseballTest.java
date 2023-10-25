package baseball.gameutil;

import baseball.gameutil.validate.ValidateInput;
import baseball.gameutil.validate.ValidateInputGame;
import baseball.gameutil.validate.ValidateInputRerun;
import baseball.message.MessageString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateInputBaseballTest {

    ValidateInput validateInputGame = ValidateInputGame.getInstance();
    ValidateInput validateInputRerun = ValidateInputRerun.getInstance();

    @Test
    void 게임중_세_자리_미만_문자열() {
        //given
        String input = "13";

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputGame.validate(input);
            }
        );

        //then
        String expected = MessageString.GAME_LEN_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_네_자리_이상_문자열() {
        //given
        String input = "0123";

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputGame.validate(input);
            }
        );

        //then
        String expected = MessageString.GAME_LEN_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_금지된_문자열_존재() {
        //given
        String input = "1a3";

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputGame.validate(input);
            }
        );

        //then
        String expected = MessageString.WRONG_GAME_INPUT_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_제로가_포함된_경우() {
        String input = "103";

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputGame.validate(input);
            }
        );

        //then
        String expected = MessageString.WRONG_GAME_INPUT_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_중복된_문자열이_온_경우() {
        String input = "113";

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputGame.validate(input);
            }
        );

        //then
        String expected = MessageString.WRONG_GAME_INPUT_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_올바른_문자열이_온_경우() {
        String input = "123";

        //when
        String ret = validateInputGame.validate(input);

        //then
        Assertions.assertEquals(ret, input);
    }

    @Test
    void 게임재게_두_자리_이상_문자열() {
        //given
        String input = "02";

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputRerun.validate(input);
            }
        );

        //then
        String expected = MessageString.WRONG_RERUN_INPUT_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임재게_금지된_문자열_존재() {
        //given
        String input = "A";

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputRerun.validate(input);
            }
        );

        //then
        String expected = MessageString.WRONG_RERUN_INPUT_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임재게_다른숫자가_들어온_경우() {
        String input = "0";

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputRerun.validate(input);
            }
        );

        //then
        String expected = MessageString.WRONG_RERUN_INPUT_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임재게_숫자가_온_경우() {
        String input = "1";

        //when
        String ret = validateInputRerun.validate(input);

        //then
        Assertions.assertEquals(ret, input);
    }
}
