package baseball;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    ArrayList<Integer> array = new ArrayList<Integer>();
    public int generateRandomNumber() {
        array.clear();
        while (array.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (array.contains(randomNumber))
                continue;
            array.add(randomNumber);
        }

        return array.get(0) * 100 + array.get(1) * 10 + array.get(2);
    }
}
