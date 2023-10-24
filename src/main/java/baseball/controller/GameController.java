package baseball.controller;


import baseball.service.GameService;
import baseball.view.GameView;

public class GameController {

    private GameService gameService;
    private GameView gameView;

    public GameController() {
        this.gameService = new GameService();
        this.gameView = new GameView();
    }

    public void playGame() {
        gameView.printStartMessage();


        String userInput = gameView.userInput();

        // 사용자 입력 값 판단 후 출력
        String result = gameService.validateInput(userInput);
        gameView.printResult(result);
    }
}
