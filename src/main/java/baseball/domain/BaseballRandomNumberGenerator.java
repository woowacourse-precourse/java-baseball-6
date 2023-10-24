package baseball.domain;

import baseball.constants.BaseballConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class BaseballRandomNumberGenerator {

    public List<Integer> generateRandomNumber(){
        HashSet<Integer> randomNumbers = new LinkedHashSet<>();
        while (randomNumbers.size() < BaseballConstant.NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BaseballConstant.MIN_NUMBER, BaseballConstant.MAX_NUMBER);
            randomNumbers.add(randomNumber);
        }
        return new ArrayList<>(randomNumbers);
    }
}
