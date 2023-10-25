package baseball;


import baseball.controller.GameController;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args)  {

        GameController gameController = new GameController();
        gameController.getStartMessage();
        gameController.start();

    }

}
