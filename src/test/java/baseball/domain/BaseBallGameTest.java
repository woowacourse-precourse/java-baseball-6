package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

    @Test
    void init메서드로_게임이_생성되는_경우는_게임초기상태가_결정된다() {
        BaseBallNumbers computerNumbers = BaseBallNumbers.generateNumbers(List.of(1, 2, 3));
        BaseBallGame baseBallGame = BaseBallGame.init(computerNumbers);

        assertThat(baseBallGame.isNotEnd()).isTrue();
    }

    @Test
    void calculateResult는_게임결과를_계산한다() {
        BaseBallNumbers computerNumbers = BaseBallNumbers.generateNumbers(List.of(1, 2, 3));
        BaseBallGame baseBallGame = BaseBallGame.init(computerNumbers);
        BaseBallNumbers playerNumbers = BaseBallNumbers.generateNumbers(List.of(1, 2, 3));
        BaseBallGameResult threeStrike = BaseBallGameResult.of(3, 0);

        BaseBallGameResult baseBallGameResult = baseBallGame.calculateResult(playerNumbers);

        assertThat(baseBallGameResult).isEqualTo(threeStrike);
    }

    @Test
    void isNotEnd는_게임이_끝나지_않은_상태면_true를_응답한다() {
        BaseBallNumbers computerNumbers = BaseBallNumbers.generateNumbers(List.of(1, 2, 3));
        BaseBallGame baseBallGame = BaseBallGame.init(computerNumbers);

        assertThat(baseBallGame.isNotEnd()).isTrue();
    }

    @Test
    void isNotEnd는_게임이_끝난_상태면_false를_응답한다() {
        BaseBallNumbers computerNumbers = BaseBallNumbers.generateNumbers(List.of(1, 2, 3));
        BaseBallGame baseBallGame = BaseBallGame.init(computerNumbers);
        BaseBallNumbers playerNumbers = BaseBallNumbers.generateNumbers(List.of(1, 2, 3));

        baseBallGame.calculateResult(playerNumbers);

        assertThat(baseBallGame.isNotEnd()).isFalse();
    }

}
