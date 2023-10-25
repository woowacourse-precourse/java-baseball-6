package baseball.domain;

import baseball.domain.player.Player;
import baseball.domain.player.PlayerNumbers;
import baseball.global.converter.NumbersConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    NumbersConverter numbersConverter;
    PlayerNumbers playerNumbers;
    Player player;

    @BeforeEach
    void init() {
        playerNumbers = new PlayerNumbers();
        player = new Player(playerNumbers);
    }

    @DisplayName("player entity에 input값이 잘 들어가는지 확인")
    @Test
    void playerTest() {
        String input = "123";
        player.createPlayerNumbers(input);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> result = player.getPlayerThreeNumbers();

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("player entity에 같은 숫자 값이 들어가면 오류가 터지는지 확인")
    @Test
    void throwExceptionWhenInputSameNumber() {
        String input = "121";

        assertThatThrownBy(() -> player.createPlayerNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
