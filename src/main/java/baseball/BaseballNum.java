package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNum {
    private List<Integer> baseballNum = new ArrayList<>();

    public BaseballNum(String inputNum) throws IllegalArgumentException {
        if (CheckBaseballNum.isError(inputNum)) {
            throw new IllegalArgumentException();
        }
        baseballNum.add(Character.getNumericValue(inputNum.charAt(0)));
        baseballNum.add(Character.getNumericValue(inputNum.charAt(1)));
        baseballNum.add(Character.getNumericValue(inputNum.charAt(2)));
    }

    public BaseballNum() {
        while (baseballNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNum.contains(randomNumber)) {
                baseballNum.add(randomNumber);
            }
        }
    }

    int getNum(int index) {
        return (baseballNum.get(index));
    }

    int isSamePositionNum(BaseballNum comparedNum) {
        int sameNumCnt = 0;
        for (int idx = 0; idx < 3; idx++) {
            if (baseballNum.get(idx).equals(comparedNum.getNum(idx))) {
                sameNumCnt++;
            }
        }
        return (sameNumCnt);
    }

    int isContainsNum(BaseballNum comparedNum) {
        int containNumCnt = 0;

        for (int idx = 0; idx < 3; idx++) {
            if (baseballNum.contains(comparedNum.getNum(idx))) {
                containNumCnt++;
            }
        }
        return (containNumCnt);
    }

}
