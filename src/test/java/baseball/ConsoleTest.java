package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ConsoleTest {

    @Test
    void input() {
        String input = "woowa";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        String readLine = Console.readLine();
        Assertions.assertThat(readLine).isEqualTo(input);
        Console.close();
    }
}
