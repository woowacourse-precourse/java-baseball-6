package baseball;

import baseball.enums.ApplicationMessage;
import baseball.io.Output;
import baseball.game.BaseballGame;

public class Application {

    public static void main(String[] args) {
        try {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();
        } catch (IllegalArgumentException e) {
            Output.consoleLine(ApplicationMessage.EXCEPTION_OCCURRED_MESSAGE.get());
            throw e;
        }
    }

}
