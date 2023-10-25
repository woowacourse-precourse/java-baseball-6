package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 컴퓨터 측에서 사용되는 유틸 클래스
 */
public class ComputerUtil {

    /**
     * 컴퓨터가 사용할 3자리 숫자를 만들어내는 메서드
     */
    public List<Integer> generateNumber() {
        List<Integer> computerNums = new ArrayList<>();

        while (computerNums.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computerNums.contains(randomNum)) {
                computerNums.add(randomNum);
            }
        }

        return computerNums;
    }
}