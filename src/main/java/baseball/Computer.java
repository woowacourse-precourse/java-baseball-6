package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> computerDigit = new ArrayList<>();

    public void setRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while(randomNumber.size() <3) {
            int randomDigit = Randoms.pickNumberInRange(1, 9);
            if(!randomNumber.contains(randomDigit)) {
                randomNumber.add(randomDigit);
            }
        }
        this.computerDigit = randomNumber;
    }
}
