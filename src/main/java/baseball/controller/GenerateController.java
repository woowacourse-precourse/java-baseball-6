package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateController {
    public List<Integer> createRandomNumber(Integer length) {
        List<Integer> result = new ArrayList<>();

        while (result.size() != length) {
            Integer randomNumber = getRandomNumber();

            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }

    private Integer getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
