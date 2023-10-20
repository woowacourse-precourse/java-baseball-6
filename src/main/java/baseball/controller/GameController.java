package baseball.controller;

import baseball.domain.Opponent;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private InputView inputView;
    private OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        Player player = new Player();
        Opponent opponent = new Opponent();

    }
}
