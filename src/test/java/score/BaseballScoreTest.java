package score;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import player.BaseballNumbers;

public class BaseballScoreTest {

    BaseballScore score = new BaseballScore();

    @AfterEach
    public void 테스트_종료_후_점수_초기화() {
        score.clearStrikeAndBall();
    }

    @Test
    @DisplayName("투 스트라이크 설정 테스트")
    public void 투_스트라이크_테스트() {
        //given
        List<Integer> baseballNumbers1 = new ArrayList<>();
        baseballNumbers1.add(1);
        baseballNumbers1.add(2);
        baseballNumbers1.add(3);

        List<Integer> baseballNumbers2 = new ArrayList<>();
        baseballNumbers2.add(1);
        baseballNumbers2.add(2);
        baseballNumbers2.add(4);

        BaseballNumbers computerInput = new BaseballNumbers(baseballNumbers2);
        BaseballNumbers playerInput = new BaseballNumbers(baseballNumbers1);

        //when
        score.calculateStrikeAndBall(computerInput, playerInput);

        //then
        assertThat(score.getStrike()).isEqualTo(2);
    }

    @Test
    @DisplayName("투 볼 설정 테스트")
    public void 투_볼_테스트() {
        //given
        List<Integer> baseballNumbers1 = new ArrayList<>();
        baseballNumbers1.add(1);
        baseballNumbers1.add(2);
        baseballNumbers1.add(3);

        List<Integer> baseballNumbers2 = new ArrayList<>();
        baseballNumbers2.add(2);
        baseballNumbers2.add(1);
        baseballNumbers2.add(4);

        BaseballNumbers computerInput = new BaseballNumbers(baseballNumbers2);
        BaseballNumbers playerInput = new BaseballNumbers(baseballNumbers1);

        //when
        score.calculateStrikeAndBall(computerInput, playerInput);

        //then
        assertThat(score.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("원 스트라이크 원 볼 설정 테스트")
    public void 원_스트라이크_원_볼() {
        //given
        List<Integer> baseballNumbers1 = new ArrayList<>();
        baseballNumbers1.add(1);
        baseballNumbers1.add(2);
        baseballNumbers1.add(3);

        List<Integer> baseballNumbers2 = new ArrayList<>();
        baseballNumbers2.add(1);
        baseballNumbers2.add(5);
        baseballNumbers2.add(2);

        BaseballNumbers computerInput = new BaseballNumbers(baseballNumbers2);
        BaseballNumbers playerInput = new BaseballNumbers(baseballNumbers1);

        //when
        score.calculateStrikeAndBall(computerInput, playerInput);

        //then
        assertThat(score.getBall()).isEqualTo(1);
        assertThat(score.getStrike()).isEqualTo(1);
    }
}
