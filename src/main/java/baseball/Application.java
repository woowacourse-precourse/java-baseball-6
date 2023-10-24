package baseball;

import baseball.controller.StateController;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        StateController controller = new StateController();
        boolean gameState = true;
        boolean restart = false;

        OutputView.printStartMessage();
        controller.gameStart();

        while (gameState) {
            if(controller.repeatPlayerExpect()) {
                restart = controller.gameStateChange();
                gameState = restart;
            }
            if (restart) {
                controller.gameStart();
                restart = false;
            }
        }
    }
}
