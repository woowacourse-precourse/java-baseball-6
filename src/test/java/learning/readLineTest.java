package learning;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.Console;

public class readLineTest {

    @Test
    void 임의의_값을_입력받는_경우() {
        // given
        String input = "hello world 12345 6789";
        // when
        writeToStdin(input);
        // then
        Assertions.assertEquals(input, Console.readLine());
    }

    void writeToStdin(String input) {
        try (InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))) {
            System.setIn(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
