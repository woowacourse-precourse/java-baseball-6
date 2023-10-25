package baseball.controller;

import baseball.model.Computer;
import baseball.model.Numbers;
import baseball.utils.RandomNumberGenerator;
import baseball.view.OutputView;
import java.util.List;

public class ComputerController {
    private Computer computer = new Computer();

    private OutputView outputView = new OutputView();

    public void saveRandomNumbers() {
        Numbers generatedNumbers = RandomNumberGenerator.generateRandomNumbers();
        computer = Computer.from(generatedNumbers);
    }

    public void provideHint(List<Integer> inputNumbers) {
        String hint = computer.provideHint(Numbers.from(inputNumbers));
        outputView.printContents(hint);
    }

    public Boolean checkCorrectAnswer() {
        return computer.isCorrectAnswer();
    }
}
