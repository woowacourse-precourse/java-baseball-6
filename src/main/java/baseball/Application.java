package baseball;

import baseball.io.Output;
import baseball.game.BaseballGame;

public class Application {

    public static void main(String[] args) {
        try {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();
        } catch (IllegalArgumentException e) {
            Output.consoleLine("예외가 발생하여 어플리케이션을 종료합니다.");
            throw e;
        }
    }

}
