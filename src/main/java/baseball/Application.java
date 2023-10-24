package baseball;

import baseball.controller.GameController;
import baseball.view.OutView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        OutView.start();
        do{
            gameController.start();
        }while(gameController.isReStart());
    }
}
