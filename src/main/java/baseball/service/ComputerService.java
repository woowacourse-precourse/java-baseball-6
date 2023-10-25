package baseball.service;

import baseball.model.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerService {
    public List<Integer> generateBaseballNumber() {
        List<Integer> baseballNumber = new ArrayList<>();
        while (baseballNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumber.contains(randomNumber))
                baseballNumber.add(randomNumber);
        }
        return baseballNumber;
    }

    public BaseballNumber createComputerWithRandomNumber() {
        List<Integer> randomNumbers = generateBaseballNumber();
        BaseballNumber baseballNumber = new BaseballNumber(randomNumbers);
        return baseballNumber;
    }
}
