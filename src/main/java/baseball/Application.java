package baseball;

import baseball.controller.GameController;
import baseball.controller.InputController;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.ScoreBoard;
import baseball.service.ComputerService;
import baseball.service.PlayerService;
import baseball.service.ScoreBoardService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        ScoreBoard scoreBoard = new ScoreBoard();

        GameController gameController = new GameController(inputController(),
                outputView(), inputView(),
                computerService(computer, player), playerService(player), scoreBoardService(scoreBoard));
        gameController.intro();
        gameController.run();
    }

    private static InputController inputController() {
        return new InputController();
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static ComputerService computerService(Computer computer, Player player) {
        return new ComputerService(computer, player);
    }

    private static PlayerService playerService(Player player) {
        return new PlayerService(player);
    }

    private static ScoreBoardService scoreBoardService(ScoreBoard scoreBoard) {
        return new ScoreBoardService(scoreBoard);
    }
}
