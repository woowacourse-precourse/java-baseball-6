package baseball.controller;

import baseball.service.ComputerService;
import baseball.service.UserService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    OutputView output = new OutputView();
    InputView input = new InputView();
    UserService user = new UserService();
    private final ComputerService computer;

    public GameController() {
        computer = new ComputerService();
        output.printStart();
    }

    public void run() {
        output.printInputNum();
        List<Integer> inputNumbers = user.getInputNumbers(input.getInput());
    }
}
