package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.Constant.*;

public class BaseBall {
    private List<Integer> inputBallNumber;

    public BaseBall() {
        this.inputBallNumber = initBallNumbers();
    }

    public BaseBall(List<Integer> inputBallNumber) {
        this.inputBallNumber = inputBallNumber;
    }

    public List<Integer> initBallNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_THREE) {
            int randomNumber = Randoms.pickNumberInRange(START, END);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public List<Integer> getInputBallNumber() {
        return inputBallNumber;
    }

    public void setInputBallNumber(List<Integer> inputBallNumber) {
        this.inputBallNumber = inputBallNumber;
    }
}
