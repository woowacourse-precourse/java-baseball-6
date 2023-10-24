package baseball.domain;


import baseball.domain.computer.Computer;
import baseball.domain.computer.GameState;
import baseball.domain.game.GameResult;
import baseball.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameResultTest {
    @Test
    @DisplayName("strike와 ball 합이 3 이상인 경우 exception이 발생해야 한다.")
    void createExceptionByCountSumIsOverThree() {
        // given
        int strikeCount = 2;
        int ballCount = 2;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> GameResult.from(strikeCount, ballCount))
                .withMessageMatching("Strike와 Ball의 갯수는 3개를 넘을 수 없습니다.");
    }
    @Test
    @DisplayName("strike가 3개인 경우 종료됨을 확인할 수 있다.")
    void isFinishedTest() {
        // given
        int strikeCount = 3;
        int ballCount = 0;
        GameResult gameResult = GameResult.from(strikeCount, ballCount);

        // when
        boolean result = gameResult.isFinished();

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("strike가 3개가 아닌 경우 종료될 수 없다.")
    void isNotFinishedTest() {
        // given
        int strikeCount = 2;
        int ballCount = 1;
        GameResult gameResult = GameResult.from(strikeCount, ballCount);

        // when
        boolean result = gameResult.isFinished();

        // then
        assertFalse(result);
    }

    @Test
    @DisplayName("baseball game 결과를 스트라이크, 볼 별로 몇개인지 반환한다")
    void calculateBaseBallGameTest() {
        // given
        Computer computer = Computer.from(Player.createPlayerByIntegerNumbers(Arrays.asList(1, 2, 3)), GameState.RUNNING);
        Player inputNumbers = Player.createPlayerByIntegerNumbers(Arrays.asList(1, 3, 2));
        GameResult expected = GameResult.from(1, 2);

        // when
        GameResult result = GameResult.calculateBaseBallGame(inputNumbers, computer);
        // then
        assertThat(result).isEqualTo(expected);
    }
}