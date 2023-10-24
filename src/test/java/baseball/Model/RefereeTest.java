package baseball.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RefereeTest {
    private Balls userBalls;
    private Balls computerBalls;
    private Referee referee;

    @BeforeEach
    @DisplayName("객체생성")
    public void setUp() {
        referee = new Referee();
    }

    @Test
    @DisplayName("판정 테스트")
    public void ballJudgeTest() {
        userBalls = new Balls(List.of(1,2,3));
        computerBalls = new Balls(List.of(1,3,4));
        Map<String,Integer> judgement = referee.judge(userBalls, computerBalls);

        assertThat(judgement.get("ball")).isEqualTo(1);
        assertThat(judgement.get("strike")).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크 판정 테스트")
    public void strikeJudgeTest() {
        userBalls = new Balls(List.of(1,2,3));
        computerBalls = new Balls(List.of(1,2,3));
        Map<String,Integer> judgement = referee.judge(userBalls, computerBalls);

        assertThat(judgement.get("ball")).isEqualTo(0);
        assertThat(judgement.get("strike")).isEqualTo(3);
    }

    @Test
    @DisplayName("낫싱 테스트")
    public void nothingJudgeTest() {
        userBalls = new Balls(List.of(1,2,3));
        computerBalls = new Balls(List.of(4,5,6));
        Map<String,Integer> judgement = referee.judge(userBalls, computerBalls);

        assertThat(judgement.get("ball")).isEqualTo(0);
        assertThat(judgement.get("strike")).isEqualTo(0);
    }
}
