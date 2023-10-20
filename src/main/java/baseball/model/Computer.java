package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumber;

    public Computer() {
        computerNumber = new ArrayList<>();

        while(computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }
}
