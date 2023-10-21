package baseball.controller;

import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.Player;

public class GameController {
    private final OutputController outputController;
    private final InputController inputController;
    private final Computer computer;
    private final Player player;
    private GameController() {
        this.outputController = new OutputController();
        this.inputController = new InputController();
        this.computer = new Computer();
        this.player = new Player();
        setUpNewGame();
    }
    public static GameController StartGame() {
        return new GameController();
    }
    public void setUpNewGame() {
        boolean gameProcess = true;
        while(gameProcess) {
            outputController.showIntroMessage();
            computer.initComputerNumbers();
            playGame();
            outputController.showGameRestartInputMessage();
            gameProcess = inputController.isRestartGame();
        }
    }
    public void playGame() {
        boolean isGameClear = false;
        while(!isGameClear){
            outputController.showGameInputMessage();
            String input = inputController.getPlayerGuessNumber();
            Hint result = player.swingBat(computer,input);
            isGameClear = outputController.displayHint(result);
        }
    }
}
