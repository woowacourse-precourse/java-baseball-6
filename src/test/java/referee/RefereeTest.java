package referee;

import static org.assertj.core.api.Assertions.assertThat;

import hint.Hint;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RefereeTest {
    
    Hint hint = new Hint();

    @Test
    @DisplayName("심판이 strike와 ball개수를 정확히 판별하는지 테스트")
    public void 심판_스트라이크_볼_계산_테스트() {
        //given
        final List<Integer> computerBaseballNumber = List.of(1, 2, 3);
        final List<Integer> playerBaseballNumber = List.of(1, 4, 3);
        final int[] score = new int[]{2, 0};
        Hint hint = new Hint();

        //when
        int[] result = Hint.calculateStrikeAndBall(computerBaseballNumber, playerBaseballNumber);

        //then
        assertThat(result).isEqualTo(score);
    }
}
