package baseball;

import baseball.controller.StateController;
import baseball.model.ComputerModel;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        StateController controller = new StateController();
        OutputView outputView = new OutputView();

        outputView.printStartMessage();
        controller.gameStart();
        boolean gameState = true;
        while (gameState) {
            if(controller.repeatPlayerExpect()) {
                gameState = controller.gameStateChange();
                controller.gameStart();
            }
        }
    }
}
