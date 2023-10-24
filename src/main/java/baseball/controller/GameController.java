package baseball.controller;

import static baseball.util.Constants.*;

import java.util.ArrayList;
import java.util.Objects;
import baseball.service.ComputerService;
import baseball.service.UserService;
import baseball.service.UmpireService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    OutputView output = new OutputView();
    InputView input = new InputView();
    UserService user = new UserService();
    ComputerService computer = new ComputerService();
    UmpireService umpire = new UmpireService();

    ArrayList<Integer> ballStrikeCount;

    public void run() {
        output.printStart();
        ArrayList<Integer> randomNumbers = computer.getRandomNumbers();
        do {
            output.printInputNum();

            umpire.initCount();
            ArrayList<Integer> inputNumbers = user.getInputNumbers(input.getInput());
            ballStrikeCount = umpire.getResult(randomNumbers, inputNumbers);

            output.printResult(ballStrikeCount);
        } while (!Objects.equals(ballStrikeCount.get(ONE), STRIKE_SIZE));
        output.printEndGame();

        String gameStatus = umpire.getRestartNumber(input.getInput());
        if (gameStatus.equals(RESTART)) {
            restartGame();
        }
    }

    private void restartGame() {
        computer.resetNumber();
        run();
    }
}
