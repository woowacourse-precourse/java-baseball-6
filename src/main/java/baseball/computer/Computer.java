package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final List<Integer> randomList = new ArrayList<>();

    /* 랜덤 숫자가 저장된 리스트 초기화 */
    public void init() {
        randomList.clear();
    }

    /* 리스트에 랜덤 숫자 3개를 넣고 반환 */
    public List<Integer> getNewRandomList() {
        while (randomList.size() < 3) {
            isContain(Randoms.pickNumberInRange(1, 9));
        }

        return randomList;
    }

    /* 리스트에 중복된 숫자가 있는지 체크 */
    private static void isContain(int randomNumber) {
        if (!randomList.contains(randomNumber)) {
            randomList.add(randomNumber);
        }
    }
}
