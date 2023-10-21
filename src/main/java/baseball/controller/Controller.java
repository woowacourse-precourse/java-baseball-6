package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameCommand;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    private final OutputView outputView;
    private final InputView inputView;

    public Controller(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        Computer computer = Computer.createWithGenerator(new RandomNumberGenerator());
        GameCommand gameCommand = GameCommand.RESTART;
        while (GameCommand.isRestart(gameCommand)) {
            playGame(computer);
            askForRestart();
        }
    }

    private void playGame(final Computer computer) {

    }

    private GameCommand askForRestart() {
        String choice = inputView.readLine();
        return GameCommand.make(choice);
    }
}
