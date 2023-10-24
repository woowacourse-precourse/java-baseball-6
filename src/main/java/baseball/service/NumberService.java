package baseball.service;

import baseball.domain.Hint;
import baseball.domain.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberService {

    private Number machineNumber;

    public NumberService() {
        init();
    }

    public boolean isCorrect(int userNumber) {
        Number number = Number.parseNumber(userNumber);
        if (number.equals(machineNumber)) {
            return true;
        }

        return false;
    }

    public String getHint(int userNumber) {
        Number number = Number.parseNumber(userNumber);
        Hint hint = machineNumber.getHint(number);
        return hint.toString();
    }

    public void init() {

        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        machineNumber = new Number(randomNumbers);
    }

}
