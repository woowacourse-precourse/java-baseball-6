package baseball.model;

import static baseball.model.Result.BALL;
import static baseball.model.Result.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementTest {

    @DisplayName("컴퓨터 수와 플레이어 수를 비교해 스트라이크와 볼의 개수를 구한다.")
    @Test
    void judge() {
        Computer computer = new Computer(List.of(1, 2, 3));
        Player player = new Player("132");
        Judgement judgement = new Judgement();

        Map<Result, Integer> gameResult = judgement.judge(computer, player);

        assertThat(gameResult).containsEntry(STRIKE, 1);
        assertThat(gameResult).containsEntry(BALL, 2);
    }
}
