package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberFactory {

    public static int createNumber(int digitSize) {
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < digitSize) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }

        int createdNumber = combineNumber(numberList);
        return createdNumber;
    }

    private static int combineNumber(List<Integer> numberList) {
        int result = 0;
        int len = numberList.size();
        for (int i = 0; i < len; i++) {
            result += numberList.get(i) * Math.pow(10, len-1-i);
        }

        return result;
    }
}