package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Random {
    public Random() {
    }

    // 1부터 9까지 서로 다른 수로 이루어진 랜덤 3자리수 발생시키는 함수
    public String generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return NumberListConverter.integerListToString(computer);
    }
}
