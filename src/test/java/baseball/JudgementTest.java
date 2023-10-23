package baseball;

import baseball.service.*;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgementTest {
    Judgement judgement = new Judgement();

    @Test
    @DisplayName("[성공 테스트] 3스트라이크")
    void getHintSuccessTest1() {
        // given
        List<Integer> computerNums = Lists.newArrayList(1, 3, 7);
        BaseballCollection computerBalls = new BaseballCollection(() -> computerNums.remove(0));
        BaseballCollection playerBalls = new BaseballCollection("137");
        // when
        String hint = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("[성공 테스트] 1볼 1스트라이크")
    void getHintSuccessTest2() {
        // given
        List<Integer> computerNums = Lists.newArrayList(4, 9, 8);
        BaseballCollection computerBalls = new BaseballCollection(() -> computerNums.remove(0));
        BaseballCollection playerBalls = new BaseballCollection("893");
        // when
        String hint = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("[성공 테스트] 1볼")
    void getHintSuccessTest3() {
        // given
        List<Integer> computerNums = Lists.newArrayList(3, 2, 5);
        BaseballCollection computerBalls = new BaseballCollection(() -> computerNums.remove(0));
        BaseballCollection playerBalls = new BaseballCollection("247");
        // when
        String hint = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("1볼");
    }

    @Test
    @DisplayName("[성공 테스트] 2볼")
    void getHintSuccessTest4() {
        // given
        List<Integer> computerNums = Lists.newArrayList(3, 2, 5);
        BaseballCollection computerBalls = new BaseballCollection(() -> computerNums.remove(0));
        BaseballCollection playerBalls = new BaseballCollection("243");
        // when
        String hint = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("2볼");
    }

    @Test
    @DisplayName("[성공 테스트] 2볼 1스트라이크")
    void getHintSuccessTest5() {
        // given
        List<Integer> computerNums = Lists.newArrayList(9, 2, 4);
        BaseballCollection computerBalls = new BaseballCollection(() -> computerNums.remove(0));
        BaseballCollection playerBalls = new BaseballCollection("942");
        // when
        String hint = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("[성공 테스트] 3볼")
    void getHintSuccessTest6() {
        // given
        List<Integer> computerNums = Lists.newArrayList(9, 2, 4);
        BaseballCollection computerBalls = new BaseballCollection(() -> computerNums.remove(0));
        BaseballCollection playerBalls = new BaseballCollection("492");
        // when
        String hint = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("3볼");
    }

    @Test
    @DisplayName("[성공 테스트] 낫싱")
    void getHintSuccessTest7() {
        // given
        List<Integer> computerNums = Lists.newArrayList(2, 5, 4);
        BaseballCollection computerBalls = new BaseballCollection(() -> computerNums.remove(0));
        BaseballCollection playerBalls = new BaseballCollection("369");
        // when
        String hint = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(hint).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("[실패 테스트] 1볼 2스트라이크는 없는 경우의 수이다")
    void getHintFailTest1() {
        for (int testCase = 0; testCase < 10000; testCase++) {
            // given
            BaseballCollection computerBalls = new BaseballCollection(new RandomNumberGenerator());
            BaseballCollection playerBalls = new BaseballCollection(new RandomNumberGenerator());
            // when
            String hint = judgement.calculateHint(computerBalls, playerBalls);
            // then
            assertThat(hint).isNotEqualTo("1볼 2스트라이크");
        }
    }
}