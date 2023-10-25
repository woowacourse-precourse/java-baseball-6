package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber extends Number{
    public ComputerNumber() {
        super(generateRandomNumberArray());
    }

    private static List<Integer> generateRandomNumberArray() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
