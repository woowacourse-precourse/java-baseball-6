package baseball.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RefereeTest {
    private Numbers user;
    private Numbers computer;
    private Referee referee;

    @BeforeEach
    @DisplayName("객체생성")
    public void setUp() {
        referee = new Referee();
    }

    @Test
    @DisplayName("볼판정 테스트")
    public void ballJudgeTest() {
        user = new Numbers(List.of(1,2,3));
        computer = new Numbers(List.of(3,1,2));
        referee.judge(user, computer);
        Map<String,Integer> judgement = referee.getJudgement();

        assertThat(judgement.get("ball")).isEqualTo(3);
        assertThat(judgement.get("strike")).isEqualTo(0);
    }

    @Test
    @DisplayName("스트라이크 판정 테스트")
    public void strikeJudgeTest() {
        user = new Numbers(List.of(1,2,3));
        computer = new Numbers(List.of(1,2,3));
        referee.judge(user, computer);
        Map<String,Integer> judgement = referee.getJudgement();

        assertThat(judgement.get("ball")).isEqualTo(0);
        assertThat(judgement.get("strike")).isEqualTo(3);
    }

    @Test
    @DisplayName("낫싱 테스트")
    public void nothingJudgeTest() {
        user = new Numbers(List.of(1,2,3));
        computer = new Numbers(List.of(4,5,6));
        referee.judge(user, computer);
        Map<String,Integer> judgement = referee.getJudgement();

        assertThat(judgement.get("ball")).isEqualTo(0);
        assertThat(judgement.get("strike")).isEqualTo(0);
    }
}
