package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputBallCountTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams(){
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams(){
        System.setOut(System.out);
    }
    @Test
    void 출력_테스트(){
        //given
        int[] count = {0,0};
        OutputBallCount print = new OutputBallCount();
        //when
        print.printCount(count);
        //then
        Assertions.assertEquals("낫싱\n", outputMessage.toString());
    }
}
