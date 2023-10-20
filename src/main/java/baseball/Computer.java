package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> makeNewNumber(){
        List<Integer> newNumber = new ArrayList<>();
        while (newNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!newNumber.contains(randomNumber)) {
                newNumber.add(randomNumber);
            }
        }
        return newNumber;
    }
}
