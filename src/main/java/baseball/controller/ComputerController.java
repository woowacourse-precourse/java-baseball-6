package baseball.controller;

import baseball.model.Hint;
import baseball.model.Numbers;
import baseball.utils.HintGenerator;
import baseball.utils.RandomNumberGenerator;

public class ComputerController {
    private Numbers computer = new Numbers();

    public void saveRandomNumbers() {
        this.computer = RandomNumberGenerator.generateRandomNumbers();
    }

    public Boolean checkCorrectAnswer() {
        return computer.isCorrectAnswer();
    }

    public Hint provideHint(Numbers player) {
        return HintGenerator.generate(computer, player);
    }

}
