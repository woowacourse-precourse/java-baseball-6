package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_LENGTH = 3;

    String computerRandomNumber = "";

    public Computer() {
        this.computerRandomNumber = this.getComputerRandomNumber();
    }

    public String getComputerRandomNumber() {

        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
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
