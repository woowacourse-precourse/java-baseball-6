package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {


    public void run() {
        OutputView.printStartMessage();
        startNewGame();
    }
    private void startNewGame() {
        List<Integer> computerNumbers = generateComputerNumber();
        List<String> input = InputView.readPlayerNumber();

    }
    private List<Integer> generateComputerNumber(){
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
