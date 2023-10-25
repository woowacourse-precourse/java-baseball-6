package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {


    static List<Integer> computerNum = new ArrayList<>(3);

    public String generate() {
        computerNum.clear();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return convertString(computerNum);
    }

    public String convertString(List<Integer> nums) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Integer num : nums) {
            stringBuffer.append(num);
        }
        return stringBuffer.toString();
    }
}
