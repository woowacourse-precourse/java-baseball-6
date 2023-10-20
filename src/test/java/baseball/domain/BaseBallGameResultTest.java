package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseBallGameResultTest {

    @Test
    void of로_만들어지는_객체들이_가지는_값이_같다면_같은_객체로_판단한다() {
        BaseBallGameResult baseBallGameResult = BaseBallGameResult.of(1, 2);
        BaseBallGameResult expectedBaseBallGameResult = BaseBallGameResult.of(1, 2);

        assertThat(baseBallGameResult).isEqualTo(expectedBaseBallGameResult);
    }

    @Test
    void isGameEnd는_게임이_끝난_상태면_true응답한다() {
        BaseBallGameResult baseBallGameResult = BaseBallGameResult.of(3, 0);

        assertThat(baseBallGameResult.isGameEnd()).isTrue();
    }

    @Test
    void isGameEnd는_게임이_끝나지_않은_상태면_false응답한다() {
        BaseBallGameResult baseBallGameResult = BaseBallGameResult.of(2, 0);

        assertThat(baseBallGameResult.isGameEnd()).isFalse();
    }

}
