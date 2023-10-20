package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class printTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @DisplayName("게임 시작 문구 출력 테스트")
    @Test
    public void printInitTest() {
        print.printInit();
        assertEquals("숫자 야구 게임을 시작합니다.\n", outContent.toString());
    }

    @DisplayName("3개의 숫자를 모두 맞힐 경우 출력 테스트")
    @Test
    public void printWinTest() {
        print.printWin();
        assertEquals("3스트라이크\n" +
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n", outContent.toString());
    }

    @DisplayName("게임 결과 출력 테스트")
    @Test
    public void printResultTest() throws Exception {
        print print = new print();

        print.printResult(2, 1);
        assertEquals("2볼 1스트라이크\n", outContent.toString());
        outContent.reset(); // Reset the stream to test again

        print.printResult(1, 0);
        assertEquals("1볼\n", outContent.toString());
        outContent.reset();

        print.printResult(0, 1);
        assertEquals("1스트라이크\n", outContent.toString());
        outContent.reset();

        print.printResult(0, 0);
        assertEquals("낫싱\n", outContent.toString());

    }

}