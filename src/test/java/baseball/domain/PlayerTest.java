package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void 스트라이크_개수는_2개() {
        // given
        List<Integer> list = new ArrayList<>(List.of(4, 5, 6));
        Number number = new Number(list);

        String input = "458";
        Player player = new Player(NumberGenerator.createPlayerNumber(input));

        // when
        int strikeCount = player.countStrike(number);

        // then
        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    void 볼_개수는_3개() {
        // given
        List<Integer> list = new ArrayList<>(List.of(3, 6, 4));
        Number number = new Number(list);

        String input = "643";
        Player player = new Player(NumberGenerator.createPlayerNumber(input));

        // when
        int ballCount = player.countBall(number);

        // then
        assertThat(ballCount).isEqualTo(3);
    }

    @Test
    void 스트라이크_1_볼_2() {
        // given
        List<Integer> list = new ArrayList<>(List.of(7, 1, 8));
        Number number = new Number(list);

        String input = "781";
        Player player = new Player(NumberGenerator.createPlayerNumber(input));

        // when
        int strikeCount = player.countStrike(number);
        int ballCount = player.countBall(number);

        // then
        assertThat(strikeCount).isEqualTo(1);
        assertThat(ballCount).isEqualTo(2);
    }
}