package baseball.controller;

import baseball.model.Hint;
import baseball.model.Numbers;
import baseball.utils.HintGenerator;
import baseball.utils.RandomNumberGenerator;
import baseball.view.OutputView;

public class ComputerController {
    private Numbers computer = new Numbers();

    private OutputView outputView = new OutputView();

    public void saveRandomNumbers() {
        this.computer = RandomNumberGenerator.generateRandomNumbers();
    }

    public Boolean checkCorrectAnswer() {
        return computer.isCorrectAnswer();
    }
}
