package baseball.Controller;


import baseball.Model.Computer;
import baseball.Model.Numbers;
import baseball.View.InputView;
import baseball.View.OutputView;
import java.util.List;

public class Game {
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
            tryAnswer(userNumbers);
            outputView.showResult(computer);
        }
    }

    private boolean isNotOver() {
        return isNotOver;
    }

    private void tryAnswer(final List<Integer> inputNumbers) {
        Numbers userNums = new Numbers(inputNumbers);
        computer.compare(userNums);
        updateGameStatus();
    }

    private void updateGameStatus() {
        isNotOver = !computer.isThreeStrike();
    }

}

