package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumbersGenerate {
    /**
     * 3개의 랜덤 숫자의 리스트를 반환한다.
     *
     * @return
     */
    public List<Integer> createRandomNumList() {
        List<Integer> ranNumTreeList = new ArrayList<>();
        while (ranNumTreeList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!ranNumTreeList.contains(randomNumber)) {
                ranNumTreeList.add(randomNumber);
            }
        }
        return ranNumTreeList;
    }
}
