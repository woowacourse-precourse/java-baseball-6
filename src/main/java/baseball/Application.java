package baseball;

import baseball.util.ResetGame;
import baseball.view.Output;
import baseball.controller.GamePlay;


public class Application {
    public static void main(String[] args) {
        Output.printGameStart();
        boolean isReset = true;

        while(isReset) {
            GamePlay.playing();
            isReset = ResetGame.isReset();
        }
    }
}