package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final List<Integer> randomList = new ArrayList<>();

    // 난수 생성
    public void initComputerList() {
        randomList.clear();
    }

    public List<Integer> createRandomList() {
        while (randomList.size() < 3) {
            isContain(Randoms.pickNumberInRange(1, 9));
        }

        return randomList;
    }

    private static void isContain(int randomNumber) {
        if (!randomList.contains(randomNumber)) {
            randomList.add(randomNumber);
        }
    }
}
