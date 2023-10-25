package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MessageTest {
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

    @Test
    void 볼_스트라이크_테스트() {
        int strike = 2;
        int ball = 1;
        Message.call(strike, ball);
        assertThat(outContent.toString()).isEqualTo("1볼 2스트라이크\n");
    }

    @Test
    void 낫싱_테스트() {
        int strike = 0;
        int ball = 0;
        Message.call(strike, ball);
        assertThat(outContent.toString()).isEqualTo("낫싱\n");
    }
}
