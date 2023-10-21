package baseball.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RefereeTest {
    private Numbers userNumbers;
    private Numbers computerNumbers;
    private Referee referee;

    @BeforeEach
    @DisplayName("객체생성")
    public void setUp() {
        referee = new Referee();
    }

    @Test
    @DisplayName("판정 테스트")
    public void ballJudgeTest() {
        userNumbers = new Numbers(List.of(1,2,3));
        computerNumbers = new Numbers(List.of(1,3,4));
        referee.judge(userNumbers, computerNumbers);
        Map<String,Integer> judgement = referee.getJudgement();

        assertThat(judgement.get("ball")).isEqualTo(1);
        assertThat(judgement.get("strike")).isEqualTo(1);
    }

    @Test
    @DisplayName("스트라이크 판정 테스트")
    public void strikeJudgeTest() {
        userNumbers = new Numbers(List.of(1,2,3));
        computerNumbers = new Numbers(List.of(1,2,3));
        referee.judge(userNumbers, computerNumbers);
        Map<String,Integer> judgement = referee.getJudgement();

        assertThat(judgement.get("ball")).isEqualTo(0);
        assertThat(judgement.get("strike")).isEqualTo(3);
    }

    @Test
    @DisplayName("낫싱 테스트")
    public void nothingJudgeTest() {
        userNumbers = new Numbers(List.of(1,2,3));
        computerNumbers = new Numbers(List.of(4,5,6));
        referee.judge(userNumbers, computerNumbers);
        Map<String,Integer> judgement = referee.getJudgement();

        assertThat(judgement.get("ball")).isEqualTo(0);
        assertThat(judgement.get("strike")).isEqualTo(0);
    }
}
