package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> com = new ArrayList<>();

    public void setCom() {
        while (com.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!com.contains(randomNumber)) {
                com.add(randomNumber);
            }
        }
    }

    public void clearCom() {
        com.clear();
    }

    public List<Integer> getCom() {
        return com;
    }
}
