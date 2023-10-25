package baseball.console;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OutputTest {

    private static ByteArrayOutputStream outputMessage;
    private static final String[] result = {"낫싱\n", "2볼 1스트라이크\n", "3볼\n"
            , "2스트라이크\n"};
    private static final int[] ball = {0, 2, 3, 0};
    private static final int[] strike = {0, 1, 0, 2};

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void printNothingMessage_메소드로_알맞은_결과_출력() {
        Output.print(ball[0], strike[0]);
        assertEquals(result[0], outputMessage.toString());
    }

    @Test
    void printBallAndStrikeMessage_메소드로_알맞은_결과_출력() {
        Output.print(ball[1], strike[1]);
        assertEquals(result[1], outputMessage.toString());
    }

    @Test
    void printBallMessage_메소드로_알맞은_결과_출력() {
        Output.print(ball[2], strike[2]);
        assertEquals(result[2], outputMessage.toString());
    }

    @Test
    void printStrikeMessage_메소드로_알맞은_결과_출력() {
        Output.print(ball[3], strike[3]);
        assertEquals(result[3], outputMessage.toString());
    }

}