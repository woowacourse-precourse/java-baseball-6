package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNum {
    private final List<Integer> number = new ArrayList<>();

    public BaseballNum(String inputNum) {
        CheckBaseballNum.isError(inputNum);
        number.add(Character.getNumericValue(inputNum.charAt(0)));
        number.add(Character.getNumericValue(inputNum.charAt(1)));
        number.add(Character.getNumericValue(inputNum.charAt(2)));
    }

    public BaseballNum() {
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }

    int getNum(int index) {
        return (number.get(index));
    }

    int isSamePositionNum(BaseballNum comparedNum) {
        int sameNumCnt = 0;

        for (int idx = 0; idx < 3; idx++) {
            if (number.get(idx).equals(comparedNum.getNum(idx))) {
                sameNumCnt++;
            }
        }
        return (sameNumCnt);
    }

    int isContainsNum(BaseballNum comparedNum) {
        int containNumCnt = 0;

        for (int index = 0; index < 3; index++) {
            if (number.contains(comparedNum.getNum(index))) {
                containNumCnt++;
            }
        }
        return (containNumCnt);
    }

}
