package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.umpire.Judgement;
import baseball.umpire.Result;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class JudgementTest {

    @Test
    void judgement() {
        //Given
        List<Integer> opponent = new ArrayList<>();
        opponent.add(1);
        opponent.add(2);
        opponent.add(3);

        List<Integer> player = new ArrayList<>();
        player.add(1);
        player.add(2);
        player.add(4);

        //When
        Result result = Judgement.countSB(opponent, player);

        //Then
        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getBall()).isEqualTo(0);
    }
}