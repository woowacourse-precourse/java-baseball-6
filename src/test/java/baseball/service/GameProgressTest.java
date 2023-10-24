package baseball.service;

import baseball.model.CompareResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameProgressTest {

    private GameProgress gameProgress;

    @BeforeEach
    void setUp() {

        gameProgress = new GameProgress();
    }

    @Test
    @DisplayName("컴퓨터와 사용자의 숫자를 비교하여 스트라이크와 볼의 수를 반환한다")
    void compareNumbersTest() {
        // given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> userNumbers = Arrays.asList(1, 3, 2);

        // when
        CompareResult result = gameProgress.compareNumbers(computerNumbers, userNumbers);

        // then
        assertAll(
                () -> assertThat(result.strikes()).isEqualTo(1),
                () -> assertThat(result.balls()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("3 스트라이크일 경우 게임 종료를 반환한다")
    void isEndGameTest() {
        // given
        CompareResult compareResult = new CompareResult(3, 0);

        // when
        boolean isEndGame = gameProgress.isEndGame(compareResult);

        // then
        assertThat(isEndGame).isTrue();
    }

    @Test
    @DisplayName("3 스트라이크가 아닐 경우 게임을 계속 진행한다.")
    void isEndGameFalseTest() {
        // given
        CompareResult compareResult = new CompareResult(2, 0);

        // when
        boolean isEndGame = gameProgress.isEndGame(compareResult);

        // then
        assertThat(isEndGame).isFalse();
    }

    @Test
    @DisplayName("사용자 번호가 1인 경우 게임 재시작을 결정한다")
    void decideGameRestartTest() {
        // given
        int userNumber = 1;

        // when
        boolean isRestart = gameProgress.decideGameRestart(userNumber);

        // then
        assertThat(isRestart).isTrue();
    }

    @Test
    @DisplayName("사용자 번호가 2인 경우 게임을 종료한다.")
    void decideGameEndTest() {
        // given
        int userNumber = 2;

        // when
        boolean isRestart = gameProgress.decideGameRestart(userNumber);

        // then
        assertThat(isRestart).isFalse();
    }
}
