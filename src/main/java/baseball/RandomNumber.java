package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomNumber {
    private List<Integer> randomNumber = new ArrayList<>();
    private final NumberValidation numberValidation = new NumberValidation();

    // 메서드명 create 사용해도 괜찮은가
    public void createNumber() {
        while (randomNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(number)) {
                randomNumber.add(number);
            }
        }
    }

    public int[] validateNumber(String inputNumber) {
        int ball = numberValidation.getBallNumber(randomNumber, inputNumber);
        int strike = numberValidation.getStrikeNumber(randomNumber, inputNumber);
        int[] result = new int[2];
        result[0] = ball;
        result[1] = strike;
        return result;
    }

    // 밖에서 delete 해도 될까? 객체를 게임마다 새로 만들어야 할까?
    public void deleteNumber() {
        randomNumber.clear();
    }
}
