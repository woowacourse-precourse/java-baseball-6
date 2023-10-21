package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final OutputView outputView;
    private final InputView inputView;
    private final Computer computer;
    private final Player player;
    private GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.computer = new Computer();
        this.player = new Player();
        setUpNewGame();
    }
    public static GameController StartGame() {
        return new GameController();
    }
    public void setUpNewGame() {
        outputView.showIntroMessage();
        computer.initComputerNumbers();
    }
    public void playGame() {
        boolean isGameClear = false;
        while(!isGameClear){
            isGameClear = player.swingBat(computer);
        }
        outputView.showGameClearMessage();
        outputView.showGameRestartInputMessage();
    }
}
