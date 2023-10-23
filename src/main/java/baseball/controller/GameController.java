package baseball.controller;

import baseball.service.ComputerService;
import baseball.service.UserService;
import baseball.service.UmpireService;
import baseball.util.Constants;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.Objects;

public class GameController {
    OutputView output = new OutputView();
    InputView input = new InputView();
    UserService user = new UserService();
    private final ComputerService computer;

    public GameController() {
        computer = new ComputerService();
    }

    public void run() {
        output.printStart();
        UmpireService umpire = new UmpireService();
        ArrayList<Integer> randomNumbers = computer.getRandomNumbers();
        ArrayList<Integer> ballStrikeCount;
        do {
            output.printInputNum();
            umpire.initCount();
            ArrayList<Integer> inputNumbers = user.getInputNumbers(input.getInput());

            ballStrikeCount = umpire.getResult(randomNumbers, inputNumbers);
            output.printResult(ballStrikeCount);
        } while (!Objects.equals(ballStrikeCount.get(Constants.ONE), Constants.STRIKE_SIZE));
        output.printEndGame();
    }
}
