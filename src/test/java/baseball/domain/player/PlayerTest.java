package baseball.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.baseballnumber.BaseballNumbers;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[PlayerTest]")
class PlayerTest {

    @Test
    @DisplayName("플레이어의 숫자를 변경할 수 있다.")
    void canChangePlayerNumber() {
        // given
        List<Integer> originalNumbers = Arrays.asList(1, 2, 3);
        BaseballNumbers originalBaseballNumber = new BaseballNumbers(originalNumbers);
        Player player = new Player();
        player.changeNumbers(originalBaseballNumber);

        List<Integer> changeNumbers = Arrays.asList(1, 2, 3);
        BaseballNumbers changeBaseballNumbers = new BaseballNumbers(changeNumbers);

        // when
        player.changeNumbers(changeBaseballNumbers);

        // then
        assertThat(player.numbers()).isEqualTo(changeBaseballNumbers);
        assertThat(player.numbers()).isNotEqualTo(originalBaseballNumber);
    }
}