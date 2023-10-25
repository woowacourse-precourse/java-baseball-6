package baseball.Controller;


import baseball.Model.Computer;
import baseball.Model.Numbers;
import baseball.Model.Result;
import baseball.View.InputView;
import baseball.View.OutputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private static final String USER_INPUT_DELIMITER = "";
    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;
    private boolean isNotOver;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computer = new Computer();
        this.isNotOver = true;
    }

    public void play() {
        while (isNotOver()) {
            List<Integer> userNumbers = inputView.receiveInput();
            tryOnce(userNumbers);
            outputView.showResult(computer);
        }
    }

    private boolean isNotOver() {
        return isNotOver;
    }

    private void tryOnce(final List<Integer> inputNumbers) {
        Numbers userNums = new Numbers(inputNumbers);
        List<Result> results = computer.compare(userNums);
        updateGameStatus();
    }

    private void updateGameStatus() {
        isNotOver = !computer.isThreeStrike();
    }

    public int getStrikeCount() {
        return computer.getStrike();
    }

    public int getBallCount() {
        return computer.getBall();
    }

    private String[] inputNumbers() {
        return readLine().split(USER_INPUT_DELIMITER);
    }
}

