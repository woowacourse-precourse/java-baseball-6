package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> numberList = new ArrayList<>();

    public Computer() {
        setRandomNumber();
    }

    private void setRandomNumber() {
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
