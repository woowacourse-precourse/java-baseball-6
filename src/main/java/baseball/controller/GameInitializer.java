package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameInitializer {
    private final Baseball baseball = new Baseball();
    private final Computer computer = new Computer();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Player player = new Player();
    private final Controller controller = new Controller(baseball, computer, inputView, outputView, player);

    public GameInitializer() {
    }

    public void startGame() {
        outputView.startGame();
        controller.playGame();
    }
}
