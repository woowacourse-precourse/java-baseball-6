package baseball.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameHelperTest {

    @Test
    @DisplayName("startGame 메서드를 통해서 GameStarter 객체를 얻어올 수 있다.")
    public void startGame() {
        // given
        GameHelper gameHelper = new GameHelper();
        // when
        GameStarter gameStarter = gameHelper.startGame();
        // then
        Assertions.assertThat(gameStarter).isNotNull();
    }

    @Test
    @DisplayName("reStartGame 메서드를 통해서 GameStarter 객체를 얻어올 수 있다.")
    public void reStartGame() {
        // given
        GameHelper gameHelper = new GameHelper();
        // when
        GameStarter gameStarter = gameHelper.reStartGame();
        // then
        Assertions.assertThat(gameStarter).isNotNull();
    }
}