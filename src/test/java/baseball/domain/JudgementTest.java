package baseball.domain;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JudgementTest {

    Judgement judgement = new Judgement();

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
        int[] result = judgement.judgement(opponent, player);

        //Then
        assertThat(result[0]).isEqualTo(2);
        assertThat(result[1]).isEqualTo(1);
    }
}