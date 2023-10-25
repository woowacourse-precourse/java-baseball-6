package baseball.controller;

import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.GameResult;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private static final String RESTART = "1";

    public void gameStart() {
        do {
            OutputView.printStartMessage();
            oneGame();
        } while (restart());
    }

    private void oneGame() {
        GameResult gameResult;
        Computer computer = new Computer();
        do {
            Player player = new Player(InputView.readPlayerNumbers());
            Game game = new Game(computer, player);
            gameResult = game.playGame();
            OutputView.printGameResult(gameResult);
        } while (!gameResult.isSuccess());
        OutputView.printSuccessMessage();
    }

    private boolean restart() {
        String command = InputView.readRestartCommand();
        if (command.equals(RESTART)){
            return true; // 2를 입력하면 게임 루프를 종료
        }
        return false;
    }
}
