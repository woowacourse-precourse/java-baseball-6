package baseball.controller;

import baseball.controller.mapper.ResultMapper;
import baseball.model.Computer;
import baseball.model.GameCommand;
import baseball.model.UserNumbers;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final OutputView outputView;
    private final InputView inputView;

    public Controller(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        outputView.printStart();
        GameCommand gameCommand = GameCommand.RESTART;

        while (GameCommand.isRestart(gameCommand)) {
            playGame();
            gameCommand = askForRestart();
        }
    }

    private void playGame() {
        Computer computer = Computer.createWithGenerator(new RandomNumberGenerator());
        List<Integer> inputNumbers = new ArrayList<>();

        while (!isGameOver(computer, inputNumbers)) {
            inputNumbers = getInputNumbers();
            String result = getResult(computer, inputNumbers);
            outputView.printResult(result);
        }
        outputView.printEnd();
    }

    private boolean isGameOver(final Computer computer, final List<Integer> inputNumbers) {
        return computer.isThreeStrikes(inputNumbers);
    }

    private List<Integer> getInputNumbers() {
        outputView.printInputNumber();
        String numbers = inputView.readLine();
        UserNumbers user = UserNumbers.createWithInput(numbers);
        return user.getNumbers();
    }

    private static String getResult(final Computer computer, final List<Integer> inputNumbers) {
        int ballCount = computer.getBallCount(inputNumbers);
        int strikeCount = computer.getStrikeCount(inputNumbers);
        return ResultMapper.resultToString(ballCount, strikeCount);
    }

    private GameCommand askForRestart() {
        outputView.printRestart();
        String choice = inputView.readLine();
        return GameCommand.make(choice);
    }
}
