package baseball.controller;

import baseball.model.Hint;
import baseball.model.Numbers;
import baseball.utils.HintGenerator;
import baseball.utils.RandomNumberGenerator;

public class ComputerController {
    private Numbers computer = new Numbers();

    public void saveRandomNumbers() {
        Numbers randomNumbers = RandomNumberGenerator.generateRandomNumbers();
        this.computer = randomNumbers;
    }

    public boolean checkCorrectAnswer(Hint hint) {
        return hint.isThreeStrike();
    }

    public Hint provideHint(Numbers player) {
        return HintGenerator.generate(computer, player);
    }

}
