package baseball.service;

import baseball.model.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerService {
    public static List<Integer> generateBaseballNumber() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }

        List<Integer> baseballNumber = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int randomIndex = Randoms.pickNumberInRange(0, digits.size() - 1);
            int digit = digits.remove(randomIndex);
            baseballNumber.add(digit);
        }
        return baseballNumber;
    }

    public static BaseballNumber createComputerWithRandomNumber() {
        List<Integer> randomNumbers = generateBaseballNumber();
        BaseballNumber baseballNumber = new BaseballNumber(randomNumbers);
        return baseballNumber;
    }
}
