package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.model.Player;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PlayerTest의")
public class PlayerTest {

    private final Player player = new Player();

    @Test
    @DisplayName("String이 List<Integer> 형식으로 변환되는가")
    void check_update_data_type() {
        //given
        String input = "123";

        //when
        player.updateNumbers(input);

        //then
        assertTrue(player.getInputNumbers() instanceof List<Integer> );
    }

    @Test
    @DisplayName("입력값을 올바르게 가져오는가")
    void check_get_input_number() {
        //give, when
        String input = "123";
        player.updateNumbers(input);

        //then
        List<Integer> expectedList = Arrays.asList(1, 2, 3);

        assertThat(player.getInputNumbers()).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("입력값이 1 ~ 9 범위를 벗어나면 예외 발생")
    void validate_one_to_nine() {
        String input = "120";
        assertThatThrownBy(() -> player.updateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값중 중복된 값이 있으면 예외 발생")
    void validate_duplicate() {
        String input = "999";
        assertThatThrownBy(() -> player.updateNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
