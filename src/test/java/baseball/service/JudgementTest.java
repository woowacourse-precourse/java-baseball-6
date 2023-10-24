package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.service.domain.BaseballCollection;
import baseball.service.domain.RandomNumberGenerator;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgementTest {
    Judgement judgement = new Judgement();

    @Test
    @DisplayName("[성공 테스트] 3스트라이크")
    void getHintSuccessTest1() {
        // given
        List<Integer> computerNums = Lists.newArrayList(1, 3, 7);
        BaseballCollection computerBalls = BaseballCollection.ofComputerBaseball(() -> computerNums.remove(0));
        BaseballCollection playerBalls = BaseballCollection.ofPlayerBaseball("137");
        // when
        GameResult gameResult = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(gameResult.getHint()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("[성공 테스트] 1볼 1스트라이크")
    void getHintSuccessTest2() {
        // given
        List<Integer> computerNums = Lists.newArrayList(4, 9, 8);
        BaseballCollection computerBalls = BaseballCollection.ofComputerBaseball(() -> computerNums.remove(0));
        BaseballCollection playerBalls = BaseballCollection.ofPlayerBaseball("893");
        // when
        GameResult gameResult = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(gameResult.getHint()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("[성공 테스트] 1볼")
    void getHintSuccessTest3() {
        // given
        List<Integer> computerNums = Lists.newArrayList(3, 2, 5);
        BaseballCollection computerBalls = BaseballCollection.ofComputerBaseball(() -> computerNums.remove(0));
        BaseballCollection playerBalls = BaseballCollection.ofPlayerBaseball("247");
        // when
        GameResult gameResult = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(gameResult.getHint()).isEqualTo("1볼");
    }

    @Test
    @DisplayName("[성공 테스트] 2볼")
    void getHintSuccessTest4() {
        // given
        List<Integer> computerNums = Lists.newArrayList(3, 2, 5);
        BaseballCollection computerBalls = BaseballCollection.ofComputerBaseball(() -> computerNums.remove(0));
        BaseballCollection playerBalls = BaseballCollection.ofPlayerBaseball("243");
        // when
        GameResult gameResult = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(gameResult.getHint()).isEqualTo("2볼");
    }

    @Test
    @DisplayName("[성공 테스트] 2볼 1스트라이크")
    void getHintSuccessTest5() {
        // given
        List<Integer> computerNums = Lists.newArrayList(9, 2, 4);
        BaseballCollection computerBalls = BaseballCollection.ofComputerBaseball(() -> computerNums.remove(0));
        BaseballCollection playerBalls = BaseballCollection.ofPlayerBaseball("942");
        // when
        GameResult gameResult = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(gameResult.getHint()).isEqualTo("2볼 1스트라이크");
    }

    @Test
    @DisplayName("[성공 테스트] 3볼")
    void getHintSuccessTest6() {
        // given
        List<Integer> computerNums = Lists.newArrayList(9, 2, 4);
        BaseballCollection computerBalls = BaseballCollection.ofComputerBaseball(() -> computerNums.remove(0));
        BaseballCollection playerBalls = BaseballCollection.ofPlayerBaseball("492");
        // when
        GameResult gameResult = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(gameResult.getHint()).isEqualTo("3볼");
    }

    @Test
    @DisplayName("[성공 테스트] 낫싱")
    void getHintSuccessTest7() {
        // given
        List<Integer> computerNums = Lists.newArrayList(2, 5, 4);
        BaseballCollection computerBalls = BaseballCollection.ofComputerBaseball(() -> computerNums.remove(0));
        BaseballCollection playerBalls = BaseballCollection.ofPlayerBaseball("369");
        // when
        GameResult gameResult = judgement.calculateHint(computerBalls, playerBalls);
        // then
        assertThat(gameResult.getHint()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("[실패 테스트] 1볼 2스트라이크는 없는 경우의 수이다")
    void getHintFailTest1() {
        for (int testCase = 0; testCase < 10000; testCase++) {
            // given
            BaseballCollection computerBalls = BaseballCollection.ofComputerBaseball(new RandomNumberGenerator());
            BaseballCollection playerBalls = BaseballCollection.ofComputerBaseball(new RandomNumberGenerator());
            // when
            GameResult gameResult = judgement.calculateHint(computerBalls, playerBalls);
            // then
            assertThat(gameResult.getHint()).isNotEqualTo("1볼 2스트라이크");
        }
    }
}