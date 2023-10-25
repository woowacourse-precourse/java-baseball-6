package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputTest {

    Output output = new Output();

    @Test
    void 결과출력() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String gameResult = "21";

        //when
        output.printResult(gameResult);

        //then
        assertThat(out.toString()).contains("2볼 1스트라이크");
    }
}