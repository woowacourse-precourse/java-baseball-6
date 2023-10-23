package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerInput {
    private static List<String> computer = new ArrayList<>();

    public void reset() {
        computer.clear();
    }

    //컴퓨터 값 입력
    public void create() {

        while (computer.size() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public List<String> value() {
        return computer;
    }
}
