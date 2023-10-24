package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Player{
    public List<Integer> setInput() {
        List<Integer> new_numbers = new ArrayList<>();
        while (new_numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!new_numbers.contains(randomNumber)) {
                new_numbers.add(randomNumber);
            }
        }
        return new_numbers;
    }


}
