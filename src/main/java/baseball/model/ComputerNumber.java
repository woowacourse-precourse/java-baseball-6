package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private String computerNumber;

    public ComputerNumber() {
        createComputerNumber();
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public void createComputerNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(randomNum)) {
                randomNumber.add(randomNum);
            }
        }
        this.computerNumber = randomNumber.toString().replaceAll("[^0-9]", "");
    }
}
