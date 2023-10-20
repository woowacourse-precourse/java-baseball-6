package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Random {
    private String randomNumber;

    public Random() {}

    // 1부터 9까지 서로 다른 수로 이루어진 랜덤 3자리수 발생시키는 함수
    public void generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.randomNumber = NumberListConverter.integerListToString(computer);
    }

    public String getRandomNumber() {
        return this.randomNumber;
    }

}
