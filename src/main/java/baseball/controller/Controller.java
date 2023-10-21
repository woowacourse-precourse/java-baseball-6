package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.Player;
import baseball.util.ConsoleMessage;
import baseball.util.Constants;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    private boolean isGameInProgress;

    public Controller() {
        isGameInProgress = true;
        OutputView.printlnConsoleMessage(ConsoleMessage.START_GAME);
    }

    public void play() {
        while (isGameInProgress) {
            runGame();
            quitOrRestartGame();
        }
    }

    private void quitOrRestartGame() {
        OutputView.printlnConsoleMessage(ConsoleMessage.THREE_STRIKE_GAME_END);
        String command = InputView.inputRestartNumber();
        if (Integer.parseInt(command) == Constants.QUIT) {
            isGameInProgress = false;
        }
    }

    private static void runGame() {
        Computer computer = new Computer();
        Player player = new Player();
        Game game = new Game();
        playGameLoop(game, computer, player);
    }

    private static void playGameLoop(Game game, Computer computer, Player player) {
        while (game.getStrikes() != Constants.NUMBER_LENGTH) {
            game.compareNumbers(computer.getNumber(), player.getNumber(InputView.inputPlayerNumber()));
            OutputView.printGameResult(game.getStrikes(), game.getBalls());
        }
    }
}
