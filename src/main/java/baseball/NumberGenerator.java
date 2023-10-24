package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    // 각각 다른 3자리 숫자를 랜덤하게 리턴해주는 메소드
    public static List<Integer> getRandomNumberList() {
        List<Integer> randomComputerList = new ArrayList<>();
        while (randomComputerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomComputerList.contains(randomNumber)) {
                randomComputerList.add(randomNumber);
            }
        }

        return randomComputerList;
    }
}
