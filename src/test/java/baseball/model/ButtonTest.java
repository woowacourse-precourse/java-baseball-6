package baseball.model;

import static baseball.model.Button.GAME_START;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ButtonTest {

    @Test
    void findByNameTest() {
        String name = "1";

        Assertions.assertThat(Button.findByName(name))
                .isEqualTo(GAME_START);
    }
}
