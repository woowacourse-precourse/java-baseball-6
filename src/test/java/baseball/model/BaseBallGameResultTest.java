package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseBallGameResultTest {

    @Test
    void 게임결과가_같다면_같은_객체로_판단한다() {
        BaseBallGameResult baseBallGameResult = BaseBallGameResult.of(1, 2);
        BaseBallGameResult expectedBaseBallGameResult = BaseBallGameResult.of(1, 2);

        assertThat(baseBallGameResult).isEqualTo(expectedBaseBallGameResult);
    }

    @Test
    void 게임결과가_모두_스트라이크이면_게임이_종료됨을_의미한다() {
        BaseBallGameResult baseBallGameResult = BaseBallGameResult.of(3, 0);

        assertThat(baseBallGameResult.isGameEnd()).isTrue();
    }

    @Test
    void 게임결과가_모두_스트라이크가_아니라면_게임이_끝나지_않음을_의미한다() {
        BaseBallGameResult baseBallGameResult = BaseBallGameResult.of(2, 0);

        assertThat(baseBallGameResult.isGameEnd()).isFalse();
    }

}
