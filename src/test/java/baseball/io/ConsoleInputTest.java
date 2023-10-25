package baseball.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsoleInputTest {

    @Test
    void 입력_받기() {
        String test = "안녕하세요! 김현우 입니다!";
        //given
        Input consoleInput = () -> test;

        //when
        String output = consoleInput.getInput();

        // then
        Assertions.assertEquals(test, output);
    }
}
