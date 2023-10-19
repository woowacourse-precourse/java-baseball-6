package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    String output() {
        return captor.toString().trim();
    }

    @Test
    void 게임시작_메시지_출력() {
        assertThat(output()).contains("숫자 야구 게임을 시작합니다.");
    }
}
