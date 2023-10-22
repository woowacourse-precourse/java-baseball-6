package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers implements Numbers {

    private final List<Integer> numbers = new ArrayList<>(SIZE);;

    public ComputerNumbers() {
        while(numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
