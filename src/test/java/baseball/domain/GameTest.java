package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;


class GameTest {
    @Test
    @DisplayName("Game 클래스를 생성할 때 computerAnswer가 만들어 진다.")
    void gameGeneratorShouldMakeComputerAnswerAndRegister() {
        // given, when
        Game game = new Game();
        List<Integer> computerAnswer = game.getComputerNumbers();

        // then
        assertThat(computerAnswer)
                .hasSize(3)
                .allMatch(number -> number >= 1 && number <= 9)
                .doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("사용자 입력값을 가지고 게임 결과를 계산후 정확하게 반환한다.")
    void makeGameResultCorrectly() {
        // given
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<String> answerCandidate =
                List.of("낫싱", "1볼", "2볼", "1볼 1스트라이크", "1스트라이크", "2스트라이크", "3스트라이크");

        // when, then
        for (int i = 0; i < 1000; i++) {
            Game game = new Game();
            GameResult gameResult = game.makeGameResult(userNumbers);

            assertThat(gameResult.toString()).isIn(answerCandidate);
        }
    }

    @Test
    @DisplayName("사용자가 정답을 맞추었다면 isUserWin이 true가 된다.")
    void isUserWinShouldBecomeTrueWhenUserMatchComputerNumbers() {
        // given
        Game game = new Game();
        List<Integer> userNumbers = game.getComputerNumbers();

        // when
        GameResult gameResult = game.makeGameResult(userNumbers);

        // then
        assertThat(gameResult.toString()).isEqualTo("3스트라이크");
        assertThat(game.isUserWin()).isEqualTo(true);
    }
}