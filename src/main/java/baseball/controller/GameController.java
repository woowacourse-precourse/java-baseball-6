package baseball.controller;

import baseball.service.ComputerService;
import baseball.service.UserService;
import baseball.service.UmpireService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;

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
        UmpireService umpire = new UmpireService();
        output.printInputNum();
        ArrayList<Integer> randomNumbers = computer.getRandomNumbers();
        ArrayList<Integer> inputNumbers = user.getInputNumbers(input.getInput());

        ArrayList<Integer> ballStrikeCount = umpire.getResult(randomNumbers, inputNumbers);
        output.printResult(ballStrikeCount);
    }
}
