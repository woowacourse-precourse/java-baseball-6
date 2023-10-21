package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computer;

    public Computer() {
        List<Integer> digit = new ArrayList<>();

        while (digit.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!digit.contains(randomNumber)) {
                digit.add(randomNumber);
            }
        }

        computer = digit;
    }


    public List<Integer> getComputer() {
        return computer;
    }

}
