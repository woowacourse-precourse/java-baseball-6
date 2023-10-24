package baseball;

import baseball.controller.GameController;
import baseball.controller.GameState;
import baseball.service.GameService;
import baseball.service.RandomGeneratorService;
import baseball.service.UserInputService;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new UserInputService(), new GameService(), new RandomGeneratorService());
        GameState gameState = GameState.START;
        while(gameState != GameState.END){
            gameState = gameController.startBaseBallGame(gameState);
        }
    }
}
