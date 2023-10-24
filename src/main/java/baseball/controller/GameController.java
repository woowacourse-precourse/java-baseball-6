package baseball.controller;

import baseball.domain.Game;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private GameService gameService;
    private boolean isGameFinished;

    public GameController(Game game) {
        this.gameService = new GameService(game);
        this.isGameFinished = false;
    }



    public void startGame() {
        OutputView.printGameStartMessage();
        gameService.startNewGame();
        isGameFinished = false;
        playGame();
    }

    public void playGame() {
        while (!isGameFinished) {
            String userInput = InputView.enterUserNumber();
            String resultMessage = gameService.playGame(userInput);
            OutputView.printGameResult(resultMessage);

            if (resultMessage.equals("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")) {
                isGameFinished = true;
            }

        }
    }


    public boolean restartGame() {
        String userChoice = InputView.choiceRetryGame();
        if ("1".equals(userChoice)) {
            gameService.startNewGame();
            isGameFinished = false;
            return false; // 게임 재시작
        } else if ("2".equals(userChoice)) {
            isGameFinished = true;
            return true; // 게임 종료
        }
        return false; // 기본적으로 게임 계속
    }

}
