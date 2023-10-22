package baseball.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class OutputTest {

    @Test
    void console_테스트() {
        String message = "hello, precourse!";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);
        Output.console(message);

        assertThat(outputStream.toString()).isEqualTo(message);
    }

    @Test
    void consoleLine_테스트() {
        String message = "hello, java-baseball";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        System.setOut(customPrintStream);
        Output.consoleLine(message);

        assertThat(outputStream.toString()).isEqualTo(message + "\n");
    }

}