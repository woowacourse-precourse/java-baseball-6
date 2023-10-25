package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    // 랜덤 숫자 생성 메서드
    public static List<Integer> createRandomNumber() {

        List<Integer> randomNumList = new ArrayList<>();
        while (randomNumList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumList.contains(randomNumber)) {
                randomNumList.add(randomNumber);
            }
        }

        return randomNumList;
    }
}
