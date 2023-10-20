package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class PickRandomNumber {
    public String pickRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return numToStr(computer);
    }

    private String numToStr(List<Integer> numberList) {
        String str = "";
        for(int i = 0 ; i < numberList.size() ; i++) {
            str += numberList.get(i) + "";
        }

        return str;
    }
}
