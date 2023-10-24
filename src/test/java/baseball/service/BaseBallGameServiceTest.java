package baseball.service;

import baseball.model.Game;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameServiceTest {

    BaseBallGameService baseBallGameService = new BaseBallGameService();

    @Test
    @DisplayName("String -> int , 리스트 요소가 int형이어야한다.")
    void inputNumberToListTest() {
        // given
        String input = "236";
        // when
        Game game = baseBallGameService.inputNumberToList(new Game(), input);
        // then
        Assertions.assertThat(game.getNumber().get(0)).isInstanceOf(Integer.class);
        Assertions.assertThat(game.getNumber().get(1)).isInstanceOf(Integer.class);
        Assertions.assertThat(game.getNumber().get(2)).isInstanceOf(Integer.class);
    }

    @Test
    @DisplayName("3스트라이크 시 True를 반환해야한다.")
    void isCorrectTest() {
        // given
        Game game = new Game();
        game.setNumber(game.getComputer());
        // when
        baseBallGameService.countStrike(game);
        Boolean result = baseBallGameService.isCorrect(game);
        // then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("3스트라이크 시 스트라이크 개수는 3이어야한다.")
    void countStrikeTest() {
        // given
        Game game = new Game();
        game.setNumber(game.getComputer());
        // when
        baseBallGameService.countStrike(game);
        // then
        Assertions.assertThat(game.getStrike()).isEqualTo(3);
    }

    @Test
    @DisplayName("3스트라이크 시 볼 개수는 0개여야한다.")
    void countBallTest() {
        // given
        Game game = new Game();
        game.setNumber(game.getComputer());
        // when
        baseBallGameService.countBall(game);
        // then
        Assertions.assertThat(game.getBall()).isEqualTo(0);
    }
}