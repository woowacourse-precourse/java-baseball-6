package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private final String computerNumber;

    public ComputerNumber() {
        this.computerNumber = generateRandomNumber();


    }

    public String getComputerNumber() {
        return computerNumber;


    }

    private String generateRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber.toString().replaceAll("[^1-9]", "");

    }


}
