package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computer_num;

    public List<Integer> Computer() {
        computer_num = new ArrayList<>();

        while (computer_num.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer_num.contains(randomNumber)) {
                computer_num.add(randomNumber);
            }
        }
        return computer_num;
    }
}

