package player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    Player player = new Player();

    public void provideUserInput(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }

    @Test
    @DisplayName("플레이어의 입력이 123인지 확인하는 테스트")
    public void 플레이어_입력_정상_테스트() {
        //given
        String playerInput = "123";
        provideUserInput(playerInput);

        //when
        List<Integer> playerBaseballNumber = player.inputPlayerNumber();

        //then
        assertThat(playerBaseballNumber).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("올바르지 않은 입력시 IllegalArgumentException 발생하는지")
    public void 플레이어_입력_오류_테스트() {
        //given
        final String playerInput = "1234";
        provideUserInput(playerInput);

        //when, then
        assertThatThrownBy(player::inputPlayerNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리의 숫자만 입력가능합니다.");
    }
}
