package baseball.game;

import baseball.Computer;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StartGamePlayTest {

    // TODO Computer.random 을 랜덤 수로 변경합니다.
    @Test
    @DisplayName("Computer.random 을 랜덤 수로 변경합니다.")
    public void StartGamePlayTest() throws Exception {
        // given
        Computer.number = "123";

        // when
        StartGamePlay startGamePlay = new StartGamePlay();
        startGamePlay.play(List.of());

        // then
        Assertions.assertThat(Computer.number.length()).isEqualTo(3);
        Assertions.assertThat(Computer.number).isNotEqualTo("123");
        Assertions.assertThat(Computer.number.charAt(0)).isNotEqualTo('0');
        Assertions.assertThat(Computer.number.charAt(1)).isNotEqualTo('0');
        Assertions.assertThat(Computer.number.charAt(2)).isNotEqualTo('0');
    }

}
