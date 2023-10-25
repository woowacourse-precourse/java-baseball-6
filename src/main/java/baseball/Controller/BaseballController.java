package baseball.Controller;

import baseball.Domain.Computer;
import baseball.Domain.GameStatus;
import baseball.Domain.User;
import baseball.Service.BaseballService;
import baseball.View.GameRoundResultView;
import baseball.View.GameSetView;
import baseball.View.InGameView;

public class BaseballController {
    private Computer computer;
    private User user;
    private GameStatus gameStatus;
    private InGameView inGameView;
    private GameRoundResultView gameRoundResultView;
    private GameSetView gameSetView;
    private BaseballService baseballService;

    public BaseballController() {
        computer = new Computer();
        user = new User();
        gameStatus = new GameStatus();
        inGameView = new InGameView();
        gameRoundResultView = new GameRoundResultView();
        gameSetView = new GameSetView();
        baseballService = new BaseballService();
    }

    public void startGame() {
        computer.setAnswerNumber();
        while (gameStatus.getGameStatus() == 1) {
            int[] ballCount = userGuess();
            printResult(ballCount);
            checkGameSet(ballCount);
        }
    }

    public int[] userGuess() {
        user.setUserNumber(inGameView.userInput());
        return baseballService.checkNumber(computer.getAnswerNumber(), user.getUserNumber());
    }

    public void printResult(int[] ballCount) {
        gameRoundResultView.printResult(ballCount);
    }

    public void checkGameSet(int[] ballCount) {
        if (baseballService.checkGameSet(ballCount)) {
            checkRestart();
        }
    }

    private void checkRestart() {
        gameSetView.printGameSetMessage();
        int number = gameSetView.restartInput();
        if (number == 1) {
            computer.setAnswerNumber();
        } else if (number == 2) {
            gameStatus.setGameStatus(2);
        }
    }
}
