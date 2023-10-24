package baseball.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrintStrikeAndBall() {
        OutputView.printStrikeAndBall(2, 1);
        assertEquals("2볼 1스트라이크\r\n", outContent.toString());

        outContent.reset();

        OutputView.printStrikeAndBall(0, 3);
        assertEquals("3스트라이크\r\n", outContent.toString());

        outContent.reset();

        OutputView.printStrikeAndBall(0, 0);
        assertEquals("낫싱\r\n", outContent.toString());
    }

    @Test
    public void testPrintStart() {
        OutputView.printStart();
        assertEquals("숫자 야구 게임을 시작합니다.\r\n", outContent.toString());
    }

    @Test
    public void testPrintSuccess() {
        OutputView.printSuccess();
        assertEquals("3스트라이크\r\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\r\n", outContent.toString());
    }
}
