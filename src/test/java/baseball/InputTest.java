package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class InputTest {
    InputView inputView = new InputView();

    @Test
    void 입력_테스트() {
        String input = "123\n1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(inputView.inputGuideMsg()).isEqualTo(new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }});
        assertThrows(IllegalArgumentException.class, () -> inputView.inputGuideMsg());
    }
}
