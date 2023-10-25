package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComNums {
    private List<Integer> comNums;

    public ComNums() {
        List<Integer> comList = new ArrayList<>();
        while (comList.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!comList.contains(randomNum)) {
                comList.add(randomNum);
            }
        }
        this.comNums = comList;
    }

    public boolean contains(int num) {
        return comNums.contains(num);
    }

    public int get(int num) {
        return comNums.get(num);
    }

    public int size() {
        return comNums.size();
    }
}
