package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public static void setRandomNumber() {
        List<Integer> randomNumber = generateRandomNumber();
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> randomNum = new ArrayList<>();
        while(randomNum.size() < 3) {
            int randomNumberByComputer = Randoms.pickNumberInRange(1, 9);
            if(!randomNum.contains(randomNumberByComputer)) {
                randomNum.add(randomNumberByComputer);
            }
        }
        return randomNum;
    }
}
