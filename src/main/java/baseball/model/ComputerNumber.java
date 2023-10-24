package baseball.model;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    public static List<Integer> generateComputerNumbers() {

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            Randoms Randoms = null;
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
