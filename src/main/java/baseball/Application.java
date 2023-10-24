package baseball;

import baseball.controller.GameController;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        GameController gameController = new GameController();

        gameController.start();

        while(true){
            gameController.play(inputView.readUserBaseballNumber());

            if(!gameController.isWin()) {
                continue;
            }

            if(!gameController.restart(inputView.readUserRestartStatus())) {
                break;
            }
        }

    }

}
