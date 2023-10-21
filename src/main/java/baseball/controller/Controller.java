package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {
    private boolean isGameInProgress;

    public Controller() {
        isGameInProgress = true;
        OutputView.printlnConsoleMessage("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        while (isGameInProgress) {
            runGame();
            quitOrRestartGame();
        }
    }

    private void quitOrRestartGame() {
        OutputView.printlnConsoleMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        String command = InputView.inputRestartNumber();
        if (command.equals("2")) {
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
        while (game.getStrikes() != 3) {
            game.compareNumbers(computer.getNumber(), player.getNumber(InputView.inputPlayerNumber()));
            OutputView.printGameResult(game.getStrikes(), game.getBalls());
        }
    }
}
