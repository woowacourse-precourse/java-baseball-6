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
            if (!isContainList(ranNumTreeList, randomNumber)) {
                ranNumTreeList.add(randomNumber);
            }
        }
        return ranNumTreeList;
    }

    /**
     * List에 Target 숫자가 포함되어있는지 확인
     *
     * @param ranNumTreeList
     * @param randomNumber
     * @return
     */
    private boolean isContainList(List<Integer> ranNumTreeList, int randomNumber) {
        return ranNumTreeList.contains(randomNumber);
    }
}
