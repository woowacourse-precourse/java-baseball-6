package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BallCountPrinterTest {
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
    void 낫싱출력_테스트(){
        //given
        int[] count = {0,0};
        BallCountPrinter print = new BallCountPrinter();
        //when
        print.printBallCount(count);
        //then
        Assertions.assertEquals("낫싱\n", outputMessage.toString());
    }
    @Test
    void 볼출력_테스트(){
        //given
        int[] count = {0,3};
        BallCountPrinter print = new BallCountPrinter();
        //when
        print.printBallCount(count);
        //then
        Assertions.assertEquals("3볼 ", outputMessage.toString());
    }

    @Test
    void 스트라이크출력_테스트(){
        //given
        int[] count = {3,0};
        BallCountPrinter print = new BallCountPrinter();
        //when
        print.printBallCount(count);
        //then
        Assertions.assertEquals("3스트라이크\n", outputMessage.toString());
    }
}
