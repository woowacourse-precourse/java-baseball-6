package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {

    public void setAutoNumber(List<Integer> numbers) {
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
