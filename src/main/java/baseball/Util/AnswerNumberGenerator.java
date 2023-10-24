package baseball.Util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerNumberGenerator {

    /**
     * 정답 숫자를 생성한다.
     *
     * @return 3자리의 랜덤 숫자 리스트
     */
    public List<Integer> generateAnswerNumber() {
        List<Integer> number = new ArrayList<>();
        boolean[] isExist = new boolean[10];

        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!isExist[randomNumber]) {
                number.add(randomNumber);
                isExist[randomNumber] = true;
            }
        }

        return number;
    }
}
