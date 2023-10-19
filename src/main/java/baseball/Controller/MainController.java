package baseball.Controller;

public class MainController {
    GameController gameController;

    public MainController() {
        gameController = new GameController();
    }

    public void startProgram() {
        boolean whetherRestart = false;
        do {
            gameController.startGame();

        } while(whetherRestart);
    }
}
