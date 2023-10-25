package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    @Test
    @DisplayName("스트라이크 확인")
    void judgeStrike() {
        // given
        Judge judge = new Judge();
        // when

        // then
        assertThat("3스트라이크").isEqualTo(judge.judgement(Arrays.asList(1,2,3), Arrays.asList(1,2,3)));

    }

    @Test
    @DisplayName("볼 확인")
    void judgeBall() {
        // given
        Judge judge = new Judge();

        // when
        // then
        assertThat("3볼").isEqualTo(judge.judgement(Arrays.asList(1,2,3), Arrays.asList(3,1,2)));
    }

    @Test
    @DisplayName("낫싱 확인")
    void judgeNothing() {
        // given
        Judge judge = new Judge();
        // when
        // then
        assertThat("낫싱").isEqualTo(judge.judgement(Arrays.asList(1,2,3), Arrays.asList(4,5,6)));

    }

}