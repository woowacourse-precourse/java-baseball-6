package baseball.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    void consoleLine() {
        String message = "테스트 문구입니다.";

        String input = message + "\n";
        InputStream customInput =
                new BufferedInputStream(new ByteArrayInputStream(input.getBytes()));
        System.setIn(customInput);
        String userInput = Input.consoleLine();

        Assertions.assertThat(userInput).isEqualTo(message);
    }
}