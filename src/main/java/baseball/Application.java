package baseball;

import baseball.config.BaseBallGameConfigFactory;
import baseball.domain.game.Game;

public class Application {
    public static void main(String[] args) {
        final Game baseBallGame = BaseBallGameConfigFactory.createBaseBallGame();
        baseBallGame.play();
    }

}
