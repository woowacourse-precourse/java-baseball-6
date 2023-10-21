package baseball.mytest.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    public String generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            checkForDuplicates(computer, randomNumber);
        }
        return convertListToString(computer);
    }

    private void checkForDuplicates(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    private String convertListToString(List<Integer> randomNumber) {
        return randomNumber.toString();
    }
}
