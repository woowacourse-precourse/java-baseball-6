package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    private Long id;
    private List<Integer> inputBallNumber;

    public BaseBall() {
        this.inputBallNumber = initBallNumbers();
    }

    public BaseBall(List<Integer> inputBallNumber) {
        this.inputBallNumber = inputBallNumber;
    }

    public List<Integer> initBallNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getInputBallNumber() {
        return inputBallNumber;
    }

    public void setInputBallNumber(List<Integer> inputBallNumber) {
        this.inputBallNumber = inputBallNumber;
    }
}
