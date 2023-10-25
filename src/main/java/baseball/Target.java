package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Target {
    private final List<Integer> numberList = new ArrayList<>();

    public Target() {
        while (this.numberList.size() < 3) {
            int randomInt = Randoms.pickNumberInRange(1, 9);
            if (!this.numberList.contains(randomInt)) {
                this.numberList.add(randomInt);
            }
        }
    }

    public List<Integer> getNumberList() {
        return this.numberList;
    }
}
