package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OutputTest {

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
        String expected = OutputMessage.START.message + "\n";

        Output.printGameStart();

        String output = outputStream.toString();
        assertEquals(expected, output);
    }

    @Test
    void 플레이어의_입력을_받을때_요구사항에_맞는_문구를_출력한다() {
        String expected = OutputMessage.INPUT_NUMBER.message;

        Output.printReceivingInput();

        String output = outputStream.toString();
        assertEquals(expected, output);
    }

    @Test
    void 플레이어의_입력에_해당하는_점수를_요구사항에_맞게_출력한다() {
        Result score = new Result(2, 1);
        String expected = score.getResultInKorean() + "\n";

        Output.printGameScore(score.getResultInKorean());

        String output = outputStream.toString();
        assertEquals(expected, output);
    }

    @Test
    void 게임이_끝났을때_요구사항에_맞는_문구를_출력한다() {
        String expected = OutputMessage.GAME_CLEAR.message + "\n";

        Output.printGameClear();

        String output = outputStream.toString();
        assertEquals(expected, output);
    }

    @Test
    void 게임이_끝나고_재시작_여부를_묻는_문구를_요구사항에_맞게_출력한다() {
        String expected = OutputMessage.RETRY_OR_END.message + "\n";

        Output.printAskingRetry();

        String output = outputStream.toString();
        assertEquals(expected, output);
    }
}