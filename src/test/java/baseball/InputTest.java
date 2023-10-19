package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    void 입력_테스트() {
        String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThat(InputView.inputGuideMsg()).isEqualTo(123);
    }
}
