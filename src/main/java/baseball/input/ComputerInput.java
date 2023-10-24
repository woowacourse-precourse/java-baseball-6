package baseball.input;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerInput {
    private static List<String> computer = new ArrayList<>();

    public void create() {

        while (computer.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<String> value() {
        return Collections.unmodifiableList(computer);
    }

    public void reset() {
        computer.clear();
    }
}
