package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 상대방 역할
 * 1. 서로 다른 숫자 카드 생성. -> done
 */
public class ComputerV1 {
    public List<Integer> setNums() {
        List<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNums.contains(randomNumber)) {
                computerNums.add(randomNumber);
            }
        }
        return computerNums;
    }
}
