package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {

    public ArrayList<Integer> setComputerNumber(ArrayList<Integer> computerNumber) {
        computerNumber.clear();

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }
}
