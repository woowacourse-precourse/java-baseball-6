package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> number;

    public Computer() {
        this.number = makeRandomNumber();
    }

    List<Integer> makeRandomNumber(){
        this.number = new ArrayList<>();
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }

    public List<Integer> getNumber() {
        return number;
    }

}
