package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    static Computer computer;
    private Computer () {}

    public static Computer getInstance() {
        if (computer == null) {
            computer = new Computer();
        }
        return computer;
    }


    static List<Integer> computerNum = new ArrayList<>(3);
    public String generate() {
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum.toString();
    }
}
