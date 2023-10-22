package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OutputCommanderTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        printStream = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(printStream);
    }

    @Test
    void 게임을_시작할때_요구사항에_맞는_문구를_출력한다() {
        OutputCommander outputCommander = new OutputCommander();
        String expected = OutputMessage.START.message + "\n";

        outputCommander.printGameStart();

        String output = outputStream.toString();
        assertEquals(expected, output);
    }

    @Test
    void 플레이어의_입력을_받을때_요구사항에_맞는_문구를_출력한다() {
        OutputCommander outputCommander = new OutputCommander();
        String expected = OutputMessage.INPUT_NUMBER.message;

        outputCommander.printReceivingInput();

        String output = outputStream.toString();
        assertEquals(expected, output);
    }

}