package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printGameStart();
        Computer computer = Computer.createByNumber(Computer.createRandomNumbers());
        List<Integer> computerNumber = computer.getComputerNumber();
        System.out.println(computerNumber);
        Player player = Player.createNyNumber(inputView.readPlayerNumber());
        System.out.println(player.getPlayerNumber());

    }
}
