package baseball;

import baseball.model.Computer;
import baseball.model.GameCommand;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        Computer computer = new Computer();

        outputView.printStartMessage();

        while (true) {

            Game game = Game.getInstance(outputView, inputView, computer);
            game.run();

            GameCommand command = new GameCommand(inputView.readEndCommand());
            if (command.isEndSign()) {
                break;
            }

        }
    }
}
