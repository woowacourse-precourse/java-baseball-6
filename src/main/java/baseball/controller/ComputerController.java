package baseball.controller;

import baseball.model.Computer;
import baseball.model.Numbers;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerController {
    private Computer computer = new Computer();

    private OutputView outputView = new OutputView();

    public void saveRandomNumbers() {
        List<Integer> generatedNumbers = generateRandomNumbers();
        computer.saveNumbers(generatedNumbers);
    }

    public void provideHint(List<Integer> inputNumbers) {
        String hint = computer.provideHint(Numbers.from(inputNumbers));
        outputView.printContents(hint);
    }

    public Boolean checkCorrectAnswer() {
        return computer.isCorrectAnswer();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
