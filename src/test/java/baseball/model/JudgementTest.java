package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgementTest {

    @DisplayName("컴퓨터 수와 플레이어 수를 비교해 게임 결과를 판정한다.")
    @Test
    void judge() {
        // given
        Computer computer = new Computer(List.of(1, 2, 3));
        Judgement judgement = new Judgement(computer);
        Player player = new Player(List.of(3, 2, 1));

        // when
        judgement.judge(player);

        // then
        assertThat(judgement.getStrike()).isEqualTo(1);
        assertThat(judgement.getBall()).isEqualTo(2);
    }
}
