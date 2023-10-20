package score;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreTest {

    Score score = new Score();

    @AfterEach
    public void 테스트_종료_후_점수_초기화() {
        score.clearStrikeAndBall();
    }

    @Test
    @DisplayName("투 스트라이크 설정 테스트")
    public void 투_스트라이크_테스트() {
        //given
        List<Integer> computerInput = List.of(4, 2, 3);
        List<Integer> playerInput = List.of(1, 2, 3);

        //when
        score.setStrikeAndBall(computerInput, playerInput);

        //then
        assertThat(score.getStrike()).isEqualTo(2);
    }

    @Test
    @DisplayName("투 볼 설정 테스트")
    public void 투_볼_테스트() {
        //given
        List<Integer> computerInput = List.of(3, 1, 4);
        List<Integer> playerInput = List.of(1, 2, 3);

        //when
        score.setStrikeAndBall(computerInput, playerInput);

        //then
        assertThat(score.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("원 스트라이크 원 볼 설정 테스트")
    public void 원_스트라이크_원_볼() {
        //given
        List<Integer> computerInput = List.of(1, 4, 2);
        List<Integer> playerInput = List.of(1, 2, 3);

        //when
        score.setStrikeAndBall(computerInput, playerInput);

        //then
        assertThat(score.getBall()).isEqualTo(1);
        assertThat(score.getStrike()).isEqualTo(1);
    }


}
