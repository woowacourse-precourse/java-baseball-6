package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CorrectNumber {

    private List<Integer> correctNumbers = new ArrayList<>();

    public void generateCorrectNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.correctNumbers = computer;
    }

    public List<Integer> getCorrectNumbers() {
        return correctNumbers;
    }
}
