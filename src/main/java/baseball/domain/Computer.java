package baseball.domain;

import static baseball.constant.Baseball.NUMBER_SIZE;
import static baseball.constant.Baseball.RANGE_END;
import static baseball.constant.Baseball.RANGE_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> numbers;

    // 1에서 9까지 서로 다른 임의의 수 3개를 선택해서 List에 저장
    public void init() {
        numbers = new ArrayList<>();

        while (numbers.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public int getNumberOf(int index) {
        return numbers.get(index);
    }

    public boolean contains(int num) {
        if (numbers.contains(num)) {
            return true;
        }
        return false;
    }
}
