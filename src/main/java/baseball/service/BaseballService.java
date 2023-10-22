package baseball.service;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballService {
    private final InputView inputView = new InputView();

    public List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public void baseballGameStart(List<Integer> integerList) {
        boolean isDifferent = true;
        while (isDifferent) {
            String input = inputView.getInput();

        }
    }

}
