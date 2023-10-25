package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameResultOutputTest {

    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    void strikeTest() {
        BaseBall answer = BaseBall.getInstance(123);
        BaseBall baseBall = BaseBall.getInstance(124);
        BaseBallResult baseBallResult = baseBall.compareWithAnswer(answer);
        GameResultOutput.print(baseBallResult);
        assertEquals("2스트라이크", captor.toString().trim());
    }

    @Test
    void ballTest() {
        BaseBall answer = BaseBall.getInstance(123);
        BaseBall baseBall = BaseBall.getInstance(415);
        BaseBallResult baseBallResult = baseBall.compareWithAnswer(answer);
        GameResultOutput.print(baseBallResult);
        assertEquals("1볼", captor.toString().trim());
    }

    @Test
    void ballStrikeTest() {
        BaseBall answer = BaseBall.getInstance(123);
        BaseBall baseBall = BaseBall.getInstance(321);
        BaseBallResult baseBallResult = baseBall.compareWithAnswer(answer);
        GameResultOutput.print(baseBallResult);
        assertEquals("2볼 1스트라이크", captor.toString().trim());
    }

    @Test
    void nothingTest() {
        BaseBall answer = BaseBall.getInstance(123);
        BaseBall baseBall = BaseBall.getInstance(456);
        BaseBallResult baseBallResult = baseBall.compareWithAnswer(answer);
        GameResultOutput.print(baseBallResult);
        assertEquals("낫싱", captor.toString().trim());
    }
}