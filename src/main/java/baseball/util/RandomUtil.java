package baseball.util;

import baseball.constant.ApplicationConstant;
import baseball.validation.ValidationNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {
    private List<Integer> randomNumber;
    private RandomUtil() {
    }

    public static RandomUtil of() {
        return new RandomUtil();
    }

    public List<Integer> getRandomNumber() {
        createRandomNumber();
        return randomNumber;
    }

    private void createRandomNumber() {
        randomNumber = new ArrayList<>();
        while (randomNumber.size() < ApplicationConstant.NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(ApplicationConstant.MIN_NUMBER, ApplicationConstant.MAX_NUMBER);
            if (!this.randomNumber.contains(randomNumber)) {
                this.randomNumber.add(randomNumber);
            }
        }
        ValidationNumber.validateNumbers(randomNumber);
    }
}
