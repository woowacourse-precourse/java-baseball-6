package baseball;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputTest {

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void 입력_테스트() {
        String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThat(InputView.inputGuideMsg()).isEqualTo(123);
    }
}
