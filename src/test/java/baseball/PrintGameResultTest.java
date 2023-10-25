package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Io.Output;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class PrintGameResultTest {
    @Test
    void 낫싱_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Output.printGameResult(0, 0);
        assertThat(out.toString()).isEqualTo("낫싱\n");
    }

    @Test
    void one_볼_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Output.printGameResult(0, 1);
        assertThat(out.toString()).isEqualTo("1볼 \n");
    }

    @Test
    void two_볼_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Output.printGameResult(0, 2);
        assertThat(out.toString()).isEqualTo("2볼 \n");
    }

    @Test
    void three_볼_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Output.printGameResult(0, 3);
        assertThat(out.toString()).isEqualTo("3볼 \n");
    }

    @Test
    void one_스트라이크_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Output.printGameResult(1, 0);
        assertThat(out.toString()).isEqualTo("1스트라이크 \n");
    }

    @Test
    void two_스트라이크_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Output.printGameResult(2, 0);
        assertThat(out.toString()).isEqualTo("2스트라이크 \n");
    }
    @Test
    void three_스트라이크_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Output.printGameResult(3, 0);
        assertThat(out.toString()).isEqualTo("3스트라이크 \n");
    }

    @Test
    void one_볼_one_스트라이크_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Output.printGameResult(1, 1);
        assertThat(out.toString()).isEqualTo("1볼 1스트라이크 \n");
    }

    @Test
    void two_볼_one_스트라이크_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Output.printGameResult(1, 2);
        assertThat(out.toString()).isEqualTo("2볼 1스트라이크 \n");
    }
}
