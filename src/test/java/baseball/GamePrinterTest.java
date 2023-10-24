package baseball;

import baseball.util.GamePrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GamePrinterTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        // 출력을 캡쳐하기 위한 설정
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testPrintStartMessage() {
        // 메서드 호출
        GamePrinter.startMessage();

        // 출력 결과 검증
        assertEquals("숫자 야구 게임을 시작합니다." + System.lineSeparator(), outputStream.toString());

        // 출력 스트림 초기화
        outputStream.reset();
    }

    @Test
    public void testPrintInputMessage() {
        // 메서드 호출
        GamePrinter.inputMessage();

        // 출력 결과 검증
        assertEquals("숫자를 입력해주세요 : ", outputStream.toString());

        // 출력 스트림 초기화
        outputStream.reset();
    }

    @Test
    public void testPrintStatusMessage() {
        // 볼 1, 스트라이크 1
        GamePrinter.resultMessage(1, 1);
        assertEquals("1볼 1스트라이크" + System.lineSeparator(), outputStream.toString());
        outputStream.reset();

        // 볼 0, 스트라이크 3
        GamePrinter.resultMessage(0, 3);
        assertEquals("3스트라이크" + System.lineSeparator() + "3개의 숫자를 모두 맞히셨습니다! 게임 종료" + System.lineSeparator() + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + System.lineSeparator(), outputStream.toString());
        outputStream.reset();

        // 볼 0, 스트라이크 1
        GamePrinter.resultMessage(0, 1);
        assertEquals("1스트라이크" + System.lineSeparator(), outputStream.toString());
        outputStream.reset();

        // 볼 1, 스트라이크 0
        GamePrinter.resultMessage(1, 0);
        assertEquals("1볼" + System.lineSeparator(), outputStream.toString());
        outputStream.reset();

        // 볼 0, 스트라이크 0 (낫싱)
        GamePrinter.resultMessage(0, 0);
        assertEquals("낫싱" + System.lineSeparator(), outputStream.toString());
        outputStream.reset();
    }
}
