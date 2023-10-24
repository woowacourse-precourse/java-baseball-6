package baseball.Controller;

import baseball.Model.ComputerNumbers;
import baseball.Model.PlayerNumbers;
import baseball.View.InputView;
import baseball.View.OutputView;

public class GameController {

    private static final String WARNING_END_INPUT = "1과 2중 입력 가능합니다.";
    private static final String GAME_RESTART = "1";
    private static final String GAME_QUIT = "2";

    PlayerNumbers playerNumber = new PlayerNumbers();
    ComputerNumbers computerNumbers = new ComputerNumbers();
    NumberController numberController = new NumberController();
    ComputerController computerController = new ComputerController();
    InputView inputView = new InputView();
    OutputView view = new OutputView();

    public void run() {
        boolean gamestate = true;
        while (gamestate) {
            computerController.onClearCheck();
            view.printStartGame();
            goGame();
            gamestate = restartGameOption(inputView.inputRestartGame());
        }

    }


    private void goGame() {
        computerNumbers.setComputerNumbers(numberController.getRandomNumbers());
        while (!computerController.clearCheck()) {
            startGame();
            playGame();
        }
    }

    private void startGame() {
        playerNumber.setPlayerNumbers(numberController.setingPlayerNumbers(inputView.inputPlayerNumber()));
    }

    private void playGame() {
        computerController.wakeCount();
        computerController.strikeAndBall(computerNumbers.getComputerNumbers(), playerNumber.getPlayerNumber());
        computerController.makeHint();
    }


    private boolean restartGameOption(String restart) {
        restart = restart.replaceAll(" ", "");
        if (restart.equals(GAME_RESTART)) {
            return true;
        } else if (restart.equals(GAME_QUIT)) {
            return false;
        }
        throw new IllegalArgumentException(WARNING_END_INPUT);
    }
}
