package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomValue {

    List<Integer> randomNumber = new ArrayList<>();

    // 랜덤한 3자리 수 생성
    public List<Integer> createRandomNumber() {
        while(randomNumber.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if(!randomNumber.contains(number)) {
                randomNumber.add(number);
            }
        }
        return randomNumber;
    }
}
