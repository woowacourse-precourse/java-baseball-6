package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementTest {

    @DisplayName("컴퓨터 수와 플레이어 수를 비교해 스트라이크와 볼의 개수를 구한다.")
    @Test
    void judge() {
        Computer computer = new Computer(List.of(1, 2, 3));
        Player player = new Player("132");

        Judgement judgement = new Judgement();
        judgement.judge(computer, player);

        assertThat(judgement.getStrike()).isEqualTo(1);
        assertThat(judgement.getBall()).isEqualTo(2);
    }
}
