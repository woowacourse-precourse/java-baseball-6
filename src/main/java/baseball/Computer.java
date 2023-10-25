package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public final class Computer {
    static ArrayList<Integer> getRandomNumber() {
        List<Integer> computer = new ArrayList<Integer>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        ArrayList<Integer> computerArray = new ArrayList<Integer>(computer);
        return computerArray;
    }
}
