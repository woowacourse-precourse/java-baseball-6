package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class GenerateRandomeNumber {

    public static String generateNumber() {
        Set<Integer> ranNum = new HashSet<>();
        while(ranNum.size() < 3) {
            int answerNumber = Randoms.pickNumberInRange(1,9);
            if(!ranNum.contains(answerNumber)) {
                ranNum.add(answerNumber);
            }
        }

        StringBuilder stringRanNum = new StringBuilder();
        for (int item : ranNum) {
            stringRanNum.append(item);
        }
        String result = stringRanNum.toString();
        return result;
    }
}