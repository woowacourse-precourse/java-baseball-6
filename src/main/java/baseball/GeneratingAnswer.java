package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GeneratingAnswer {
    private final int digits;

    public GeneratingAnswer(int digits) {
        this.digits = digits;
    }

    public List<Integer> generateAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < digits) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
