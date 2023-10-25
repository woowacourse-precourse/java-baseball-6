package baseball.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    OutputStream computerResult() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        return os;
    }

    @Test
    void 연산_결과_출력_테스트() {
        String newline = System.lineSeparator();

        OutputStream os = computerResult();
        OutputView.printBaseballResult(1, 0);
        assertThat(os.toString()).isEqualTo("1볼 " + newline);

        os = computerResult();
        OutputView.printBaseballResult(0, 1);
        assertThat(os.toString()).isEqualTo("1스트라이크" + newline);

        os = computerResult();
        OutputView.printBaseballResult(1, 1);
        assertThat(os.toString()).isEqualTo("1볼 1스트라이크" + newline);

        os = computerResult();
        OutputView.printBaseballResult(0, 0);
        assertThat(os.toString()).isEqualTo("낫싱" + newline);
    }
}