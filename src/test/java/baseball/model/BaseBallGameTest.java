package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BaseBallGameTest {

    @Test
    void 처음으로_생성된_게임은_내부적으로_게임이_끝나지_않는_상태를_가진다() {
        List<Integer> numbers = List.of(1, 2, 3);
        BaseBallNumbers computerNumbers = BaseBallNumbers.from(numbers);
        BaseBallGame baseBallGame = BaseBallGame.create(computerNumbers);

        assertThat(baseBallGame.isInProgress()).isTrue();
    }

    @Test
    void 사용자_야구숫자와_컴퓨터_숫자야구와_비교해서_게임결과를_계산한다() {
        BaseBallNumbers computerNumbers = BaseBallNumbers.from(List.of(1, 2, 3));
        BaseBallGame baseBallGame = BaseBallGame.create(computerNumbers);
        BaseBallNumbers playerNumbers = BaseBallNumbers.from(List.of(1, 2, 3));
        BaseBallGameResult threeStrike = BaseBallGameResult.of(3, 0);

        BaseBallGameResult baseBallGameResult = baseBallGame.determineGameResult(playerNumbers);

        assertThat(baseBallGameResult).isEqualTo(threeStrike);
    }

    @Test
    void 사용자_야구숫자가_컴퓨터_야구숫자와_동일하다면_게임이_종료된다() {
        BaseBallNumbers computerNumbers = BaseBallNumbers.from(List.of(1, 2, 3));
        BaseBallGame baseBallGame = BaseBallGame.create(computerNumbers);
        BaseBallNumbers playerNumbers = BaseBallNumbers.from(List.of(1, 2, 3));

        baseBallGame.determineGameResult(playerNumbers);

        assertThat(baseBallGame.isInProgress()).isFalse();
    }

    @Test
    void 사용자_야구숫자가_컴퓨터_야구숫자와_일치하지_않는다면_게임은_종료되지_않는다() {
        BaseBallNumbers computerNumbers = BaseBallNumbers.from(List.of(1, 2, 3));
        BaseBallGame baseBallGame = BaseBallGame.create(computerNumbers);
        BaseBallNumbers playerNumbers = BaseBallNumbers.from(List.of(4, 5, 6));

        baseBallGame.determineGameResult(playerNumbers);

        assertThat(baseBallGame.isInProgress()).isTrue();
    }

}
