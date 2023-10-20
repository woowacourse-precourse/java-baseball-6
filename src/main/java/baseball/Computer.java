package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    String computerRandomNumber = "";

    public Computer() {
        this.computerRandomNumber = this.getComputerRandomNumber();
    }

    public String getComputerRandomNumber() {

        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        String stringRandomNumber = "";
        for (Integer randomNumber : randomNumbers) {
            stringRandomNumber += String.valueOf(randomNumber);
        }

        return stringRandomNumber;
    }
}
