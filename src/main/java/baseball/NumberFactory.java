package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberFactory {

    public static int createNumber() {
        List<Integer> numberList = new ArrayList<>();

        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }

        int createdNumber = combineNumber(numberList);
        return createdNumber;
    }

    private static int combineNumber(List<Integer> numberList) {
        return numberList.get(0) * 100 + numberList.get(1) * 10 + numberList.get(2);
    }
}
