package baseball.io;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsoleOutputTest {

    @Test
    void 출력(){
        //given
        String test = "안녕하세요! 김현우라고 합니다!";
        ByteArrayOutputStream outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
        ConsoleOutput consoleOutput = new ConsoleOutput();

        //when
        consoleOutput.print(test);

        //then
        // println이므로 띄어쓰기를 해야한다.
        Assertions.assertEquals(test + "\n", outputMessage.toString());
        System.setOut(System.out);
    }
}
