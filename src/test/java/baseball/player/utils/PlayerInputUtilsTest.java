package baseball.player.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.player.utils.PlayerInputUtils.UTILS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerInputUtilsTest {
    @Test
    void convert_input_to_list() {
        assertThat(UTILS.convertInputToList("123")).isEqualTo(List.of(1, 2, 3));
    }
}