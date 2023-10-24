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
        String result = "";
        while (!result.equals("3스트라이크")) {
            String userInput = GameView.getUserInput();

            // 사용자 입력 값 판단 후 출력
            result = gameService.validateInput(userInput);
            GameView.printResult(result);
        }
        GameView.printEndMessage();
    }
}
