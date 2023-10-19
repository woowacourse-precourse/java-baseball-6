package hint;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HintTest {

    @Test
    @DisplayName("힌트의 strike와 ball 계산 테스트")
    void 힌트_스트라이크_볼_계산_테스트() {
        //given
        final List<Integer> computerBaseballNumber = List.of(1, 2, 3);
        final List<Integer> playerBaseballNumber = List.of(1, 4, 3);
        final int[] score = new int[]{2, 0};

        //when
        int[] result = Hint.calculateStrikeAndBall(computerBaseballNumber, playerBaseballNumber);

        //then
        assertThat(result).isEqualTo(score);
    }
}
