package baseball.IO;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsoleInputTest {
    @Test
    void 입력_받기(){

        //given
        String input = "안녕하세요! 김현우 입니다!";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleInput consoleInput = new ConsoleInput();

        //when
        String output = consoleInput.getInput();

        // then
        Assertions.assertEquals(input, output);
    }
}
