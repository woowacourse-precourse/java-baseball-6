package baseball.controller;

import baseball.model.GameModel;
import baseball.model.HumanModel;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private GameModel gameModel;
    private HumanModel humanModel;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        outputView.displayGameStart();
        gameModel = new GameModel();
        do {
            setHumans();
        } while (gameModel.isRunning());
    }
    private void setHumans() {
        humanModel = new HumanModel(inputView.inputNumbers());
    }
}
