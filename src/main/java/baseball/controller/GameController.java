package baseball.controller;

import baseball.model.Computer;
import baseball.model.NumberMaker;
import baseball.model.Player;
import baseball.view.Input;
import baseball.view.Output;

public class GameController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final NumberMaker numberMaker = new NumberMaker();

    public void run() {
        output.showStartMessage();
        Computer computer = new Computer(numberMaker.makeComputerNumbers());
        Player player = new Player(input.readPlayerNumbers());
    }
}
