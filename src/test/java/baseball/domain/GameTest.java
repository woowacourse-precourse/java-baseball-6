package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class GameTest {
    @Test
    @DisplayName("Game 클래스를 생성할 때 입력한 computerNumbers가 멤버변수에 등록된다.")
    void gameGeneratorShouldMakeComputerAnswerAndRegister() {
        // given, when
        List<Integer> computerNumbers = List.of(1, 2, 3);
        Game game = new Game(computerNumbers);

        // then
        assertThat(game.getComputerNumbers())
                .hasSize(3)
                .containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("사용자 입력값을 가지고 게임 결과를 계산후 정확하게 반환한다.")
    void makeGameResultCorrectly() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        Game game = new Game(computerNumbers);
        List<Integer> userNumbers = List.of(3, 2, 1);

        // when
        GameResult gameResult = game.makeGameResult(userNumbers);

        // then
        assertThat(gameResult).isEqualTo(new GameResult(2, 1, 0));
    }

    @Test
    @DisplayName("사용자가 정답을 맞추었다면 isUserWin이 true가 된다.")
    void isUserWinShouldBecomeTrueWhenUserMatchComputerNumbers() {
        // given
        List<Integer> computerNumbers = List.of(1, 2, 3);
        Game game = new Game(computerNumbers);
        List<Integer> userNumbers = List.of(1, 2, 3);

        // when
        GameResult gameResult = game.makeGameResult(userNumbers);

        // then
        assertThat(gameResult.toString()).isEqualTo("3스트라이크");
        assertThat(game.isUserWin()).isEqualTo(true);
    }
}