package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    ComputerNumber computerNumber = new ComputerNumber();

    public void startGame() {
        outputView.printStartMessage();
        computerNumber.setComputerNumbers(getRandomNumbers());
        String playerNumberStr = inputView.inputPlayerNumber();
    }

    public List<Integer> getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
