package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RandomNumber {
    private ArrayList<Integer> randomNumber = new ArrayList<Integer>();

    public ArrayList<Integer> getRandomNumber() {
        while (randomNumber.size()<3) {
            int randomInt = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(randomInt)) {
                randomNumber.add(randomInt);
            }
        }
        return randomNumber;
    }
}
