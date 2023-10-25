package baseball.controller;


import baseball.service.GameService;
import baseball.view.GameView;

public class GameController {

    private GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void playGame() {
        GameView.printStartMessage();
        String result;
        do {
            String userInput = GameView.getUserInput();
            result = gameService.validateInput(userInput);
            GameView.printResult(result);
        } while (!result.equals("3스트라이크"));
        GameView.printEndMessage();
    }
}
