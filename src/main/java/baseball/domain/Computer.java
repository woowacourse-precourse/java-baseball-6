package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.Baseballs.*;

public class Computer {

    private Baseballs baseballs;

    public Baseballs getBaseballs() {
        return baseballs;
    }

    public void setup() {
        baseballs = generateBaseballs();
    }

    private Baseballs generateBaseballs() {
        return new Baseballs(generateRandomNumbers());
    }

    private List<Integer> generateRandomNumbers() {
        Set<Integer> ballNumbers = new HashSet<>();
        while (ballNumbers.size() < BALL_SIZE) {
            ballNumbers.add(Randoms.pickNumberInRange(MIN_BALL, MAX_BALL));
        }
        return new ArrayList<>(ballNumbers);
    }

    // 테스트 에서만 사용하는 set (set을 없애기 위한 방법을 찾는중)
    public void setBaseballs(Baseballs mockBaseballs) {
        this.baseballs = mockBaseballs;
    }

}
