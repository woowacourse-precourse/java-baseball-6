package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Numbers computerNumber;

    public Computer() {
        List<Integer> number = new ArrayList<>();

        while(number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }

        computerNumber = new Numbers(number);
    }

    public Numbers getComputerNumber() {
        return computerNumber;
    }
}
