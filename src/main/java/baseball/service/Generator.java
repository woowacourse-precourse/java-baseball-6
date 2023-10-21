package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    private List<Integer> numList = new ArrayList<>();

    public Generator() {
        pickRandomNum();
    }

    private void pickRandomNum() {
        while (numList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber);
            }
        }
    }

    public String generateNum() {
        StringBuilder s = new StringBuilder(3);
        for (Integer i : numList) {
            s.append(i);
        }
        String num = s.toString();
        return num;
    }


}
