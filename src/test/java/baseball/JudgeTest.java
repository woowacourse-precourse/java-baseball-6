package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    Judge judge = new Judge();

    static List<Integer> computer;

    @BeforeEach
    void beforeEach() {
        computer = Arrays.asList(1, 2, 3);
    }

    @Test
    @DisplayName("스트라이크 확인")
    void judgeStrike() {
        // given
        List<Integer> player = Arrays.asList(1, 2, 3);

        // when
        String expectStrike = judge.judgement(computer, player);

        // then
        assertThat("3스트라이크").isEqualTo(expectStrike);

    }

    @Test
    @DisplayName("볼 확인")
    void judgeBall() {
        // given
        List<Integer> player = Arrays.asList(3, 1, 2);

        // when
        String expectBall = judge.judgement(computer, player);

        // then
        assertThat("3볼").isEqualTo(expectBall);
    }

    @Test
    @DisplayName("낫싱 확인")
    void judgeNothing() {
        // given
        List<Integer> player = Arrays.asList(4, 5, 6);

        // when
        String expectNothing = judge.judgement(computer, player);

        // then
        assertThat("낫싱").isEqualTo(expectNothing);

    }

}