package baseball;

import baseball.controller.BaseballGame;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {

        OutputView.printGameStart();
        do{
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        }while(BaseballGame.askReplay());
    }
}
