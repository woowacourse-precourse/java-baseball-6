package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComInt {
    private List<Integer> comInt;

    public ComInt() {
        this.comInt = makeComInt(new ArrayList<>());
    }

    private static List<Integer> makeComInt(List<Integer> comInt) {
        while (comInt.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comInt.contains(randomNumber)) {
                comInt.add(randomNumber);
            }
        }
        return comInt;
    }

    public int getIdx(int i) {
        return comInt.get(i);
    }

    public boolean contains(int i) {
        return comInt.contains(i);
    }
}
