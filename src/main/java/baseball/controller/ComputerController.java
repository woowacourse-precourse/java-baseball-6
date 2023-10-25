package baseball.controller;

import baseball.model.Hint;
import baseball.model.Numbers;
import baseball.utils.HintGenerator;
import baseball.utils.RandomNumberGenerator;
import java.util.List;

public class ComputerController {
    private Numbers computer = new Numbers();

    public void saveRandomNumbers() {
        List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumbers();
        computer = Numbers.from(randomNumbers);
    }

    public Boolean checkCorrectAnswer(Hint hint) {
        return hint.isThreeStrike();
    }

    public Hint provideHint(Numbers player) {
        return HintGenerator.generate(computer, player);
    }
}
