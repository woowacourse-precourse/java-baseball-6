package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameManager {

    public List<Integer> createRandNumber() {
        List<Integer> randNumbers = new ArrayList<>();
        while (randNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randNumbers.contains(randomNumber)) {
                randNumbers.add(randomNumber);
            }
        }
        return randNumbers;
    }

    public boolean validateUserBaseballNumber(String userBaseballNumber) {
        HashSet<Character> validateNumberList = new HashSet<>();
        for (int i = 0; i < userBaseballNumber.length(); i++) {
            validateNumberList.add(userBaseballNumber.charAt(i));
        }
        return validateNumberList.size() == 3;
    }
}
